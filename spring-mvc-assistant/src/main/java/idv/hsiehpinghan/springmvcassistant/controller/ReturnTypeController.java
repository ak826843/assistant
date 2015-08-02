package idv.hsiehpinghan.springmvcassistant.controller;

import idv.hsiehpinghan.springmvcassistant.dto.Data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/returnType")
public class ReturnTypeController {
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Collection<Data> list() {
		return generateList();
	}

	@RequestMapping(value = "/fileSystemResource/{fileSystemResource:.+}", method = RequestMethod.GET)
	@ResponseBody
	public FileSystemResource file(
			@PathVariable("fileSystemResource") String fileSystemResource) {
		return new FileSystemResource("/home/thank/" + fileSystemResource);
	}

	private Collection<Data> generateList() {
		return generateList(3);
	}

	private Collection<Data> generateList(int amount) {
		List<Data> datas = new ArrayList<Data>(amount);
		for (int i = 0; i < 3; ++i) {
			Integer integerValue = i;
			Float floatValue = Float.valueOf("" + i + "." + i);
			String stringValue = String.valueOf("string_" + i);
			Date dateValue = Calendar.getInstance().getTime();
			Data data = new Data(integerValue, floatValue, stringValue,
					dateValue);
			datas.add(data);
		}
		return datas;
	}
}
