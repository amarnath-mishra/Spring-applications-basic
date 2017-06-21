package com.mvcapp1.controllerpackage;

import java.util.Collection;

import javax.servlet.http.Part;

public interface FileUploadInterface {

	public int fileUpload(Collection<Part> collection,String uploadFilePath);
	
}
