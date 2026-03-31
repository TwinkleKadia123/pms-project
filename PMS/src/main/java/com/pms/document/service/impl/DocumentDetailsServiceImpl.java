package com.pms.document.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.pms.document.dao.DocumentDetailsRepository;
import com.pms.document.dao.IDocumentDetailsDAO;
import com.pms.document.entity.DocumentDetails;
import com.pms.document.service.IDocumentDetailsService;
import com.pms.search.specification.DocumentDetailsSpecification;

@Service
public class DocumentDetailsServiceImpl implements IDocumentDetailsService {


static final Logger logger = LoggerFactory.getLogger(DocumentDetailsServiceImpl.class);
	
	@Autowired
	private IDocumentDetailsDAO dao;
	
	@Autowired
	private DocumentDetailsRepository documentDetailsRepository;
	
	

	public DocumentDetailsServiceImpl(IDocumentDetailsDAO dao, DocumentDetailsRepository documentDetailsRepository) {
		super();
		this.dao = dao;
		this.documentDetailsRepository=documentDetailsRepository;
	}

	public List<DocumentDetails> getDocumentDetails() {
//		return dao.getFloors();
		return documentDetailsRepository.findAll();
	}

	public DocumentDetails createDocumentDetails(DocumentDetails documentDetails) {
//		return dao.createFloor(Floor);
		 return documentDetailsRepository.saveAndFlush(documentDetails);
	}

	public DocumentDetails updateDocumentDetails(int documentDetailsId, DocumentDetails documentDetails) {
		return dao.updateDocumentDetails(documentDetailsId, documentDetails);
	}

	public DocumentDetails getDocumentDetail(int documentDetailsId) {
		return dao.getDocumentDetail(documentDetailsId);
	}

	public boolean deleteDocumentDetails(int documentDetailsId) {
		return dao.deleteDocumentDetails(documentDetailsId);
	}
	
	
	 public DocumentDetails findById(Integer id) { // ✅ Implemented method
	        return dao.findById(id);
	    }

	 @Override
	 public List<DocumentDetails> search(String documentTypeEnum, String documentNumber) {
	        Specification<DocumentDetails> spec = Specification
	                .where(DocumentDetailsSpecification.hasDocumentTypeEnum(documentTypeEnum))
	                .and(DocumentDetailsSpecification.hasDocumentNumber(documentNumber));

	        return documentDetailsRepository.findAll(spec);
	    }


}
