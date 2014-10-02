/**
 * 
 */
package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.Equipment;

import org.springframework.data.repository.CrudRepository;

/**
 * A repository for equipments.
 * 
 */
public interface EquipmentCrudRepository extends CrudRepository<Equipment, Long> {

}