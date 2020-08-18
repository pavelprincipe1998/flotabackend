package com.incloud.hcp.service._framework.impl;

import com.incloud.hcp.domain.BaseDomain;
import com.incloud.hcp.repository._framework.JPACustomMapperMybatis;
import com.incloud.hcp.repository._framework.JPACustomRepository;
import com.incloud.hcp.service._framework.JPACustomRequiredNewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public abstract class JPACustomRequiredNewServiceImpl<T extends BaseDomain, I> implements JPACustomRequiredNewService<T> {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected MessageSource messageSource;

    @Autowired
    protected JPACustomRepository<T, I> mainRepository;

    @Autowired
    protected JPACustomMapperMybatis<T> mainMapperMybatis;

//    @Autowired
//    protected JPACustomJdbcDao<T> mainDaoJdbc;


    /**********************/
    /* METODOS CON BEAN   */
    /**********************/

    public T saveMasivo(T bean) throws Exception {
        bean = this.mainRepository.save(bean);
        return bean;
    }

    public void updateMasivo(T bean) throws Exception {
        this.mainMapperMybatis.updateBean(bean);
        return;
    }

    public void deleteMasivo(T bean) throws Exception {
        this.mainMapperMybatis.deleteBean(bean);
        return;
    }

    public void deleteAll() throws Exception {
        this.mainMapperMybatis.deleteAll();
    }


    /**********************/
    /* METODOS CON LISTA  */
    /**********************/

    public void insertMasivo(List<T> listaBean) throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        if (listaBean != null && listaBean.size() > 0) {
            map.put("list", listaBean);
            this.mainMapperMybatis.insertMap(map);
        }
    }

//    public void insertMasivoJdbc(List<T> listaBean) throws Exception{
//        this.mainDaoJdbc.insertJdbc(listaBean);
//    }
//
//    public void updateMasivoJdbc(List<T> listaBean) throws Exception{
//        this.mainDaoJdbc.updateJdbc(listaBean);
//        return;
//    }



}



