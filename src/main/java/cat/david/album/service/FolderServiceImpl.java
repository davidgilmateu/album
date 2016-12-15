package cat.david.album.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cat.david.album.dao.FolderDao;
import cat.david.album.model.File;
import cat.david.album.model.Folder;

public class FolderServiceImpl implements FolderService {

	@Autowired
	private FolderDao folderDao;
	
	@Override
	public List<Folder> listFolders(Long folderId) {
		return folderDao.listFolders(folderId);
	}

	@Override
	public List<File> listFiles(Long folderId) {
		return folderDao.listFiles(folderId);
	}

	
}
