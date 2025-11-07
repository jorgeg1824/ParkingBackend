package co.edu.uco.parking.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.parking.business.assembler.entity.impl.CellTypeEntityAssembler;
import co.edu.uco.parking.business.business.CellTypeBusiness;
import co.edu.uco.parking.business.domain.CellTypeDomain;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.data.dao.factory.DAOFactory;
import co.edu.uco.parking.entity.CellTypeEntity;

public final class CellTypeBusinessImpl implements CellTypeBusiness {

    private final DAOFactory daoFactory;

    public CellTypeBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void registerNewCellTypeInformation(final CellTypeDomain cellTypeDomain) {
        final var assembler = CellTypeEntityAssembler.getCellTypeEntityAssembler();
        final var entity = assembler.toEntity(cellTypeDomain);
        final var dao = daoFactory.getCellTypeDAO();

        try {
            // Validar que no exista un tipo de celda con el mismo nombre
            var filter = new CellTypeEntity(null, cellTypeDomain.getName(), null, true);
            var existing = dao.findByFilter(filter);

            if (!existing.isEmpty()) {
            	var userMessage = MessagesEnum.USER_ERROR_CELL_TYPE_ALREADY_EXISTS.getContent();
            	var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CELL_TYPE_ALREADY_EXISTS.getContent();
                throw ParkingException.create(userMessage, technicalMessage);
            }

            // Generar ID y establecer activo por defecto
            entity.setId(UUID.randomUUID());
            entity.setActive(true);

            dao.create(entity);

        } catch (ParkingException e) {
        	var userMessage = MessagesEnum.USER_CELL_TYPE_ERROR_REGISTERING.getContent();
        	var technicalMessage = MessagesEnum.TECHNICAL_CELL_TYPE_ERROR_REGISTERING.getContent();
            throw ParkingException.create(e, userMessage, technicalMessage);
        } catch (Exception e) {
            var userMessage = MessagesEnum.USER_CELL_TYPE_UNEXPECTED_ERROR_REGISTERING.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_CELL_TYPE_UNEXPECTED_ERROR_REGISTERING.getContent();
            throw ParkingException.create(e, userMessage, technicalMessage);
        }
    }

    @Override
    public void updateCellTypeInformation(final UUID id, final CellTypeDomain cellTypeDomain) {
        // TODO Auto-generated method stub
    }

    @Override
    public void dropCellTypeInformation(final UUID id) {
    	// TODO Auto-generated method stub
    }

    @Override
    public List<CellTypeDomain> findAllCellTypes() {
    	final var assembler = CellTypeEntityAssembler.getCellTypeEntityAssembler();
        final var dao = daoFactory.getCellTypeDAO();

        try {
            var result = dao.findAll();
            return result.stream().map(assembler::toDomain).toList();
        } catch (Exception e) {
            var userMessage = MessagesEnum.USER_CELL_TYPE_ERROR_RETRIEVING_ALL_CELL_TYPE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_CELL_TYPE_ERROR_RETRIEVING_ALL_CELL_TYPE.getContent();
            throw ParkingException.create(e, userMessage, technicalMessage);
        }
    }

    @Override
    public CellTypeDomain findSpecificCellType(final UUID id) {
    	// TODO Auto-generated method stub
    	return null;
    }

	@Override
	public List<CellTypeDomain> findCellTypesByFilter(CellTypeDomain cellTypeFilters) {
		// TODO Auto-generated method stub
		return null;
	}
}
