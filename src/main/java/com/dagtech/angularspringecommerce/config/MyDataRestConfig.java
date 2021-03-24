package com.dagtech.angularspringecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import com.dagtech.angularspringecommerce.entity.Product;
import com.dagtech.angularspringecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{

	
	private EntityManager entityManager;
	
	@Autowired
	public MyDataRestConfig(EntityManager theEntityManager) {
		
		entityManager = theEntityManager;
	}
	
	@Override
	public void configureRepositoryRestConfiguration(
			                       RepositoryRestConfiguration config) {
		
		HttpMethod[] unsupportedActions = {HttpMethod.PUT, HttpMethod.DELETE};
		
		disableHttpMethods(Product.class, config, unsupportedActions);
		disableHttpMethods(ProductCategory.class, config, unsupportedActions);
		
		// call an internal helper method
		exposeIds(config);
		
	}

	private void disableHttpMethods(Class theClass, 
			                        RepositoryRestConfiguration config,
			                        HttpMethod[] unsupportedActions) {
		
		config.getExposureConfiguration()
		      .forDomainType(theClass)
		      .withItemExposure((metdata, httpMethods) 
		    		  -> httpMethods.disable(unsupportedActions))
		      .withCollectionExposure((metdata, httpMethods) 
		    		  -> httpMethods.disable(unsupportedActions));
		
	}

	private void exposeIds(RepositoryRestConfiguration config) {
		
		// expose entity ids
	    // - get a list of all entity classes from the entity manager
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		
		// - create an array of the entity type
		List<Class> entityClasses = new ArrayList<>();
		
		// - get the entity types for the entities
		for (EntityType tempEntityType : entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}
		
		// -expose the entity ids for the array of entity/domain types
		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
	
		
	}
	
}
