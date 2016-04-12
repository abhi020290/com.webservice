package com.webservice.resource.bean;

import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;

public class FilterBean {

			private @CookieParam("cookieData")String cookie;
			private @HeaderParam("headerData")String header;
			private @MatrixParam("matrixData")String matrix;
			
			public String getCookie() {
				return cookie;
			}
			public void setCookie(String cookie) {
				this.cookie = cookie;
			}
			public String getHeader() {
				return header;
			}
			public void setHeader(String header) {
				this.header = header;
			}
			public String getMatrix() {
				return matrix;
			}
			public void setMatrix(String matrix) {
				this.matrix = matrix;
			}
}
