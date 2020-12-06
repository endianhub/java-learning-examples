package com.xh.security.filter;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/12/2
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String oldValue = super.getParameter(name);
        if (StringUtils.isEmpty(oldValue)) {
            return oldValue;
        }
        // 对html特殊字符实现转移
        String newValue = StringEscapeUtils.escapeHtml4(oldValue);
        return newValue;
    }

}
