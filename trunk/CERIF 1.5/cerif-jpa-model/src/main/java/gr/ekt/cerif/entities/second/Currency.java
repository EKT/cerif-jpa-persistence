/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_Equipment;
import gr.ekt.cerif.entities.link.project.Project_Facility;
import gr.ekt.cerif.entities.link.project.Project_Funding;
import gr.ekt.cerif.entities.link.project.Project_Service;
import gr.ekt.cerif.features.multilingual.CurrencyEntityName;
import gr.ekt.cerif.features.multilingual.CurrencyName;

import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Represents a currency second level entity.
 * 
 */
@Entity
@Table(name="cfCurrency")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Currency implements CerifSecondLevelEntity {
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 87304389612480632L;

	/**
	 * The currency code.
	 */
	@Id
	@Column(name="cfCurrCode", length=5)
	private String code;

	@Column(name="cfNumCurrCode", length=3)
	private String numeric;
	
	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	/**
	 * The UUID.
	 */
	@Column(name="cfUUID")
	private String uuid;
	
	
	/**
	 * Multilingual.
	 */
	@OneToMany(mappedBy="currency")
	private Set<CurrencyName> names;
	
	@OneToMany(mappedBy="currency")
	private Set<CurrencyEntityName> entityNames;
	
	
	/**
	 * Links.
	 */
	@OneToMany(mappedBy="currency")
	private Set<OrganisationUnit> organisationUnits;
	
	@OneToMany(mappedBy="currency")
	private Set<OrganisationUnit_ResultProduct> organisationUnitResultProducts;
	
	@OneToMany(mappedBy="currency")
	private Set<Funding> fundings;
	
	@OneToMany(mappedBy="currency")
	private Set<Project_Equipment> projects_equipments;
	
	@OneToMany(mappedBy="currency")
	private Set<Project_Facility> projects_facilities;
	
	@OneToMany(mappedBy="currency")
	private Set<Project_Service> projects_services;
	
	@OneToMany(mappedBy="currency")
	private Set<Project_Funding> projects_fundings;
	
	/**
	 * FederatedIdentifier entities related to Currency instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;
	
	//----------------------------------------------------------------------------------------------//
	
	/**
	 * Default Constructor
	 */
	public Currency(){
		
	}
	
	/**
	 * 
	 * @param code
	 * @param numeric
	 * @param uri
	 * @param names
	 * @param entityNames
	 */
	public Currency(String code, String numeric, String uri,
			Set<CurrencyName> names,
			Set<CurrencyEntityName> entityNames) {
		this.code = code;
		this.numeric = numeric;
		this.uri = uri;
		this.names = names;
		this.entityNames = entityNames;
	}

	/**
	 * Returns the code.
	 * @return the code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 * @param code the code.
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * @return the numeric
	 */
	public String getNumeric() {
		return numeric;
	}

	/**
	 * @param numeric the numeric to set
	 */
	public void setNumeric(String numeric) {
		this.numeric = numeric;
	}

	/**
	 * Returns the URI.
	 * @return the URI.
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * Sets the URI.
	 * @param uri the URI.
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the organisationUnits
	 */
	public Set<OrganisationUnit> getOrganisationUnits() {
		return organisationUnits;
	}

	/**
	 * @param organisationUnits the organisationUnits to set
	 */
	public void setOrganisationUnits(Set<OrganisationUnit> organisationUnits) {
		this.organisationUnits = organisationUnits;
	}

	/**
	 * @return the organisationUnitResultProducts
	 */
	public Set<OrganisationUnit_ResultProduct> getOrganisationUnitResultProducts() {
		return organisationUnitResultProducts;
	}

	/**
	 * @param organisationUnitResultProducts the organisationUnitResultProducts to set
	 */
	public void setOrganisationUnitResultProducts(
			Set<OrganisationUnit_ResultProduct> organisationUnitResultProducts) {
		this.organisationUnitResultProducts = organisationUnitResultProducts;
	}

	/**
	 * @return the fundings
	 */
	public Set<Funding> getFundings() {
		return fundings;
	}

	/**
	 * @param fundings the fundings to set
	 */
	public void setFundings(Set<Funding> fundings) {
		this.fundings = fundings;
	}

	/**
	 * @return the projects_equipments
	 */
	public Set<Project_Equipment> getProjects_equipments() {
		return projects_equipments;
	}

	/**
	 * @param projects_equipments the projects_equipments to set
	 */
	public void setProjects_equipments(Set<Project_Equipment> projects_equipments) {
		this.projects_equipments = projects_equipments;
	}

	/**
	 * @return the projects_facilities
	 */
	public Set<Project_Facility> getProjects_facilities() {
		return projects_facilities;
	}

	/**
	 * @param projects_facilities the projects_facilities to set
	 */
	public void setProjects_facilities(Set<Project_Facility> projects_facilities) {
		this.projects_facilities = projects_facilities;
	}

	/**
	 * @return the projects_services
	 */
	public Set<Project_Service> getProjects_services() {
		return projects_services;
	}

	/**
	 * @param projects_services the projects_services to set
	 */
	public void setProjects_services(Set<Project_Service> projects_services) {
		this.projects_services = projects_services;
	}

	/**
	 * @return the projects_fundings
	 */
	public Set<Project_Funding> getProjects_fundings() {
		return projects_fundings;
	}

	/**
	 * @param projects_fundings the projects_fundings to set
	 */
	public void setProjects_fundings(Set<Project_Funding> projects_fundings) {
		this.projects_fundings = projects_fundings;
	}

	/**
	 * @return the names
	 */
	public Set<CurrencyName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(Set<CurrencyName> names) {
		this.names = names;
	}

	/**
	 * @return the entityNames
	 */
	public Set<CurrencyEntityName> getEntityNames() {
		return entityNames;
	}

	/**
	 * @param entityNames the entityNames to set
	 */
	public void setEntityNames(Set<CurrencyEntityName> entityNames) {
		this.entityNames = entityNames;
	}

	/**
	 * @return the federatedIdentifiers
	 */
	public List<FederatedIdentifier> getFederatedIdentifiers() {
		return federatedIdentifiers;
	}

	/**
	 * @param federatedIdentifiers the federatedIdentifiers to set
	 */
	public void setFederatedIdentifiers(
			List<FederatedIdentifier> federatedIdentifiers) {
		this.federatedIdentifiers = federatedIdentifiers;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Currency [code=" + code + ", numeric=" + numeric + ", uri="
				+ uri + ", uuid=" + uuid + "]";
	}


	
}