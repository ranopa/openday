package com.kosta.openday.announcement.dao;

import java.util.List;

import com.kosta.openday.announcement.dto.AnnouncementDTO;

public interface AnnouncementDAO {
	public AnnouncementDTO selectAnnouncement(Integer ancId) throws Exception;
	public List<AnnouncementDTO> selectAnnouncementList() throws Exception;
	public void insertAnnouncement(AnnouncementDTO aDTO) throws Exception;
}
