package com.kh.training.model.vo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class TrainingImgNamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File origin) {
		String originName = origin.getName();
		String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String boardName = "러닝일지";
		String ext = originName.substring(originName.lastIndexOf("."));
		String changeName = boardName+time+ext;
		return new File(origin.getParent(), changeName);
	}

}
