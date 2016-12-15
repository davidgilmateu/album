package cat.david.album.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cat.david.album.model.Device;
import cat.david.album.model.File;
import cat.david.album.model.Folder;
import cat.david.album.util.Queries;

@Repository("folderDao")
public class FolderDaoImpl implements FolderDao {

	private Logger log = LoggerFactory.getLogger(FolderDaoImpl.class);
	
	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	private <T extends Device> List<T> list(String query, String paramName, Long folderId) {
		List<T> devices = new ArrayList<T>();
		try{
			devices = (List<T>) hibernateTemplate.findByNamedParam(query, "f", folderId);
		} catch (Exception e){
			log.error("Loading devicess in Folder:" + folderId, e);
		}
		return devices;
	}
	
	@Override
	public List<File> listFiles(Long folderId) {
		return list(Queries.ALL_FILES_IN_FOLDER, "f", folderId);
	}

	@Override
	public List<Folder> listFolders(Long folderId) {
		return list(Queries.ALL_FOLDERS_IN_FOLDER, "f", folderId);
	}
	
}
