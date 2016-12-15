package cat.david.album.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cat.david.album.service.FolderService;

@Controller
public class FolderController {

	@Autowired
	private FolderService folderService;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	@ResponseBody
	public String findByFolder(@RequestParam("folderId") Long folderId){
		return folderService.listFolders(folderId).toString() + " " + folderService.listFiles(folderId).toString() ;
	}
	
}
