package com.incloud.hcp._security;

import com.incloud.hcp.exception.ServiceException;


public interface SystemLoggedUser {

    UserSession getUserSession() throws ServiceException;
//    User getUserSCP(HttpServletRequest request);

}
