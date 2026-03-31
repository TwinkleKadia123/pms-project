/**
 * 
 */
package com.pms.search.specification;

import org.springframework.data.jpa.domain.Specification;

import com.pms.building.entity.Building;
import com.pms.document.entity.DocumentDetails;

/**
 * 
 */
public class DocumentDetailsSpecification {
	
	public static Specification<DocumentDetails> hasDocumentTypeEnum(String documentTypeEnum) {
        return (root, query, cb) ->
        documentTypeEnum == null ? null : cb.like(cb.lower(root.get("documentTypeEnum")), "%" + documentTypeEnum.toLowerCase() + "%");
    }
	
	public static Specification<DocumentDetails> hasDocumentNumber(String documentNumber) {
        return (root, query, cb) ->
        documentNumber == null ? null : cb.like(cb.lower(root.get("documentNumber")), "%" + documentNumber.toLowerCase() + "%");
    }

	
	

}
