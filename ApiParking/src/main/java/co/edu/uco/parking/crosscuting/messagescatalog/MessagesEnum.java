package co.edu.uco.parking.crosscuting.messagescatalog;

import co.edu.uco.parking.crosscuting.helper.TextHelper;

public enum MessagesEnum {
	
	USER_ERROR_SQLCONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada vacía", 
			"La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está vacía."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada nula", 
			"La conexión requerida para llevar a cabo la operación contra la base de datos llegó nula."),
	
	USER_ERROR_SQLCONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada", 
			"La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está cerrada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada", 
			"La conexión requerida para llevar a cabo la operación contra la base de datos está cerrada."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado validando el estado de la conexión contra la fuente de datos deseada", 
			"Se ha presentado un problema inesperado tratando de validar el estado de la conexión requerida para llevar a cabo la la operación contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validando si la conexión contra la base de datos estaba abierta", 
			"Se presentó un error de tipo SQLException al validar si la conexión contra la base de datos estaba o no abierta."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	TECHNIAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validando si la conexión contra la base de datos estaba abierta", 
			"Se presentó un error no controlado de tipo Exception al validar si la conexión contra la base de datos estaba o no abierta."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_TRANSACTION_IS_NOT_STARTED("Transacción contra la fuente de información deseada no iniciada", 
			"La transacción contra la fuente de información deseada no ha sido iniciada."
			+ "Por favor inicie una transacción e intente de nuevo. Si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_TRANSACTION_IS_NOT_STARTED("Transacción contra la fuente de información deseada no iniciada",
			"Se esperaba que la transacción contra la fuente de información deseada estuviera iniciada (autoCommit en false) pero se encontró que no es así (autoCommit en true)."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Problema inesperado validando si la transacción contra la fuente de información deseada estaba iniciada", 
			"Se ha presentado un problema inesperado tratando de validar si la transacción contra la fuente de información deseada estaba iniciada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Error inespereado validando si la transacción contra la fuente de información deseada estaba iniciada", 
			"Se presentó un error de tipo SQLException al validar si la transacción contra la fuente de información deseada estaba iniciada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED("Problema inesperado validando si la transacción contra la fuente de información deseada no estaba iniciada", 
			"Se ha presentado un problema inesperado tratando de validar si la transacción contra la fuente de información deseada no estaba iniciada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error inespereado validando si la transacción contra la fuente de información deseada no estaba iniciada",
			"Se presentó un error de tipo SQLException al validar si la transacción contra la fuente de información deseada no estaba iniciada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_TRANSACTION_IS_STARTED("Transacción contra la fuente de información deseada ya iniciada", 
			"La transacción contra la fuente de información deseada ya ha sido iniciada."
			+ "Por favor valide si ya existe una transacción iniciada antes de iniciar una nueva e intente de nuevo. Si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_TRANSACTION_IS_STARTED("Transacción contra la fuente de información deseada ya iniciada",
			"Se esperaba que la transacción contra la fuente de información deseada no estuviera iniciada (autoCommit en true) pero se encontró que ya estaba iniciada (autoCommit en false)."
			+ "Esto puede suceder si se intenta iniciar una transacción cuando ya existe una iniciada."),
	
	USER_ERROR_INITIALIZING_TRANSACTION("Problema inicializando la transacción contra la fuente de información deseada", 
			"Se ha presentado un problema inesperado tratando de iniciar la transacción contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_INITIALIZING_TRANSACTION("Error inespereado inicializando la transacción contra la fuente de información deseada",
			"Se presentó un error de tipo SQLException al intentar iniciar la transacción contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_INITIALIZING_TRANSACTION("Problema inesperado inicializando la transacción contra la fuente de información deseada", 
			"Se ha presentado un problema inesperado tratando de iniciar la transacción contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_INITIALIZING_TRANSACTION("Error inespereado inicializando la transacción contra la fuente de información deseada",
			"Se presentó un error no controlado de tipo Exception al intentar iniciar la transacción contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_COMMITING_TRANSACTION("Problema inesperado haciendo commit a la transacción contra la fuente de información deseada", 
			"Se ha presentado un problema inesperado tratando de hacer commit a la transacción contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_COMMITING_TRANSACTION("Error inespereado haciendo commit a la transacción contra la fuente de información deseada",
			"Se presentó un error de tipo SQLException al intentar hacer commit a la transacción contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_COMMITING_TRANSACTION("Problema inesperado haciendo commit a la transacción contra la fuente de información deseada", 
			"Se ha presentado un problema inesperado tratando de hacer commit a la transacción contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_COMMITING_TRANSACTION("Error inespereado haciendo commit a la transacción contra la fuente de información deseada",
			"Se presentó un error no controlado de tipo Exception al intentar hacer commit a la transacción contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_ROLLING_BACK_TRANSACTION("Problema inesperado haciendo rollback a la transacción contra la fuente de información deseada", 
			"Se ha presentado un problema inesperado tratando de hacer rollback a la transacción contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_ROLLING_BACK_TRANSACTION("Error inespereado haciendo rollback a la transacción contra la fuente de información deseada",
			"Se presentó un error de tipo SQLException al intentar hacer rollback a la transacción contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_ROLLING_BACK_TRANSACTION("Problema inesperado haciendo rollback a la transacción contra la fuente de información deseada",
			"Se ha presentado un problema inesperado tratando de hacer rollback a la transacción contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_ROLLING_BACK_TRANSACTION("Error inespereado haciendo rollback a la transacción contra la fuente de información deseada",
			"Se presentó un error no controlado de tipo Exception al intentar hacer rollback a la transacción contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_CLOSING_CONNECTION("Problema inesperado cerrando la conexión contra la fuente de información deseada", 
			"Se ha presentado un problema inesperado tratando de cerrar la conexión contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_CLOSING_CONNECTION("Error inespereado cerrando la conexión contra la fuente de información deseada",
			"Se presentó un error de tipo SQLException al intentar cerrar la conexión contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_CLOSING_CONNECTION("Problema inesperado cerrando la conexión contra la fuente de información deseada",
			"Se ha presentado un problema inesperado tratando de cerrar la conexión contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_CLOSING_CONNECTION("Error inespereado cerrando la conexión contra la fuente de información deseada",
			"Se presentó un error no controlado de tipo Exception al intentar cerrar la conexión contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_OPENING_CONNECTION("Problema inesperado abriendo la conexión contra la fuente de información deseada", 
			"Se ha presentado un problema inesperado tratando de abrir la conexión contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_OPENING_CONNECTION("Error inespereado abriendo la conexión contra la fuente de información deseada",
			"Se presentó un error de tipo SQLException al intentar abrir la conexión contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_OPENING_CONNECTION("Problema inesperado abriendo la conexión contra la fuente de información deseada",
			"Se ha presentado un problema inesperado tratando de abrir la conexión contra la fuente de información deseada."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_OPENING_CONNECTION("Error inespereado abriendo la conexión contra la fuente de información deseada",
			"Se presentó un error no controlado de tipo Exception al intentar abrir la conexión contra la fuente de información deseada."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_DAOFACTORY_NO_VALID_FACTORY("Problema inesperado inicializando la factoría", 
			"La fuente de información sobre la cual se va a realizar la transacción seleccionada no está disponible dentro del sistema."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAOFACTORY_NO_VALID_FACTORY("Error inicializando el DAOFactory",
			"La factoría seleccionada para la fuente de información no ha sido implementada o no está disponible en este momento."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_DAO_CREATING_USER("Problema creando el usuario", 
			"Se ha presentado un problema tratando de registrar la información del nuevo usuario."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_CREATING_USER("Error creando el usuario",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de creación de un nuevo usuario."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_DAO_UNEXPECTED_ERROR_CREATING_USER("Error inesperado creando el usuario",
			"Se presentó un problema inesperado tratando de registrar la información del nuevo usuario."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación"),
	
	TECHNICAL_ERROR_DAO_UNEXPECTED_ERROR_CREATING_USER("Error inesperado creando el usuario",
			"Se presentó un error no controlado de tipo Exception al tratar de ejecutar el proceso de creación de un nuevo usuario en la base de datos."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado"),
	
	USER_ERROR_DAO_UPDATING_USER("Problema actualizando el usuario",
	        "Se ha presentado un problema tratando de actualizar la información del usuario."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_UPDATING_USER("Error actualizando el usuario",
	        "Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de actualización de la información del usuario."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),

	USER_ERROR_DAO_UNEXPECTED_ERROR_UPDATING_USER("Error inesperado actualizando el usuario",
	        "Se presentó un problema inesperado tratando de actualizar la información del usuario."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_UNEXPECTED_ERROR_UPDATING_USER("Error inesperado actualizando el usuario",
	        "Se presentó un error no controlado de tipo Exception al tratar de ejecutar el proceso de actualización de la información del usuario en la base de datos."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_DAO_DELETING_USER("Problema eliminando el usuario",
	        "Se ha presentado un problema tratando de eliminar la información del usuario."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_DELETING_USER("Error eliminando el usuario",
	        "Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de eliminación de la información del usuario."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),

	USER_ERROR_DAO_UNEXPECTED_ERROR_DELETING_USER("Error inesperado eliminando el usuario",
	        "Se presentó un problema inesperado tratando de eliminar la información del usuario."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_UNEXPECTED_ERROR_DELETING_USER("Error inesperado eliminando el usuario",
	        "Se presentó un error no controlado de tipo Exception al tratar de ejecutar el proceso de eliminación de la información del usuario en la base de datos."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado"),
	
	USER_ERROR_DAO_FINDING_USER_BY_ID("Problema consultando el usuario por su identificador",
	        "Se ha presentado un problema tratando de consultar la información del usuario por su identificador."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_FINDING_USER_BY_ID("Error consultando el usuario por su identificador",
	        "Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de un usuario por su identificador."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),

	USER_ERROR_DAO_UNEXPECTED_ERROR_FINDING_USER_BY_ID("Error inesperado consultando el usuario por su identificador",
	        "Se presentó un problema inesperado tratando de consultar la información del usuario por su identificador."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_UNEXPECTED_ERROR_FINDING_USER_BY_ID("Error inesperado consultando el usuario por su identificador",
	        "Se presentó un error no controlado de tipo Exception al tratar de ejecutar el proceso de consulta de un usuario por su identificador en la base de datos."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado"),
	
	USER_ERROR_DAO_FINDING_ALL_USERS("Problema consultando los usuarios",
	        "Se ha presentado un problema tratando de consultar la información de los usuarios. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_FINDING_ALL_USERS("Error consultando los usuarios",
	        "Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de usuarios. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),

	USER_ERROR_DAO_UNEXPECTED_ERROR_FINDING_ALL_USERS("Error inesperado consultando los usuarios",
	        "Se presentó un problema inesperado tratando de consultar la información de los usuarios. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_UNEXPECTED_ERROR_FINDING_ALL_USERS("Error inesperado consultando los usuarios",
	        "Se presentó un error no controlado de tipo Exception al tratar de ejecutar el proceso de consulta de usuarios. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado"),
	
	USER_ERROR_DAO_FINDING_USER_BY_FILTER("Problema consultando los usuarios por filtro",
	        "Se ha presentado un problema tratando de consultar la información de los usuarios según los criterios indicados. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_FINDING_USER_BY_FILTER("Error consultando los usuarios por filtro",
	        "Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de usuarios filtrados. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),

	USER_ERROR_DAO_UNEXPECTED_ERROR_FINDING_USER_BY_FILTER("Error inesperado consultando los usuarios por filtro",
	        "Se presentó un problema inesperado tratando de consultar la información de los usuarios según los criterios indicados. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	TECHNICAL_ERROR_DAO_UNEXPECTED_ERROR_FINDING_USER_BY_FILTER("Error inesperado consultando los usuarios por filtro",
	        "Se presentó un error no controlado de tipo Exception al tratar de ejecutar el proceso de consulta de usuarios filtrados. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado"),
	
	USER_MANAGER_ERROR_DAO_CREATING_MANAGER("Problema creando el administrador", 
			"Se ha presentado un problema tratando de registrar la información del nuevo administrador."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_CREATING_MANAGER("Error creando el administrador",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de creación de un nuevo administrador."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_MANAGER_ERROR_DAO_FINDING_ALL_MANAGERS("Problema consultando los administradores",
	        "Se ha presentado un problema tratando de consultar la información de los administradores. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_ALL_MANAGERS("Error consultando los administradores",
	        "Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de administradores. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_MANAGER_ERROR_DAO_FINDING_MANAGER_BY_FILTER("Problema consultando los administradores por filtro",
	        "Se ha presentado un problema tratando de consultar la información de los administradores según los criterios indicados. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_MANAGER_BY_FILTER("Error consultando los administradores por filtro",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de administradores filtrados. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_MANAGER_ERROR_DAO_FINDING_MANAGER_BY_ID("Problema consultando el administrador por su identificador",
	        "Se ha presentado un problema tratando de consultar la información del administrador por su identificador."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_MANAGER_BY_ID("Error consultando el administrador por su identificador",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de un administrador por su identificador."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_MANAGER_ERROR_DAO_UPDATING_MANAGER("Problema actualizando el administrador",
	        "Se ha presentado un problema tratando de actualizar la información del administrador."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_UPDATING_MANAGER("Error actualizando el administrador",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de actualización de la información del administrador."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_MANAGER_ERROR_DAO_DELETING_MANAGER("Problema eliminando el administrador",
	        "Se ha presentado un problema tratando de eliminar la información del administrador."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_DELETING_MANAGER("Error eliminando el administrador",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de eliminación de la información del administrador."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ZONE_ERROR_DAO_CREATING_ZONE("Problema creando la zona", 
			"Se ha presentado un problema tratando de registrar la información de la nueva zona."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_CREATING_ZONE("Error creando la zona",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de creación de una nueva zona."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ZONE_ERROR_DAO_FINDING_ALL_ZONES("Problema consultando las zonas",
	        "Se ha presentado un problema tratando de consultar la información de las zonas. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_ALL_ZONES("Error consultando las zonas",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de zonas. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ZONE_ERROR_DAO_FINDING_ZONE_BY_FILTER("Problema consultando las zonas por filtro",
			"Se ha presentado un problema tratando de consultar la información de las zonas según los criterios indicados. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_ZONE_BY_FILTER("Error consultando las zonas por filtro",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de zonas filtradas. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ZONE_UNEXPECTED_ERROR_DAO_FINDING_ZONE_BY_FILTER("Error inesperado consultando las zonas por filtro",
			"Se presentó un problema inesperado tratando de consultar la información de las zonas según los criterios indicados. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_UNEXPECTED_ERROR_DAO_FINDING_ZONE_BY_FILTER("Error inesperado consultando las zonas por filtro",
			"Se presentó un error no controlado de tipo Exception al tratar de ejecutar el proceso de consulta de zonas filtradas. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ZONE_ERROR_DAO_FINDING_ZONE_BY_ID("Problema consultando la zona por su identificador",
	        "Se ha presentado un problema tratando de consultar la información de la zona por su identificador."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_ZONE_BY_ID("Error consultando la zona por su identificador",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de una zona por su identificador."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ZONE_UNEXPECTED_ERROR_DAO_FINDING_ZONE_BY_ID("Error inesperado consultando la zona por su identificador",
	        "Se presentó un problema inesperado tratando de consultar la información de la zona por su identificador."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_UNEXPECTED_ERROR_DAO_FINDING_ZONE_BY_ID("Error inesperado consultando la zona por su identificador",
			"Se presentó un error no controlado de tipo Exception al tratar de ejecutar el proceso de consulta de una zona por su identificador en la base de datos."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ZONE_ERROR_DAO_UPDATING_ZONE("Problema actualizando la zona",
	        "Se ha presentado un problema tratando de actualizar la información de la zona."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_UPDATING_ZONE("Error actualizando la zona",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de actualización de la información de la zona."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ZONE_ERROR_DAO_DELETING_ZONE("Problema eliminando la zona",
			"Se ha presentado un problema tratando de eliminar la información de la zona."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_DELETING_ZONE("Error eliminando la zona",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de eliminación de la información de la zona."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_MANAGER_ZONE_ERROR_DAO_CREATING_MANAGER_ZONE("Problema creando el administrador de zona", 
			"Se ha presentado un problema tratando de registrar la información del nuevo administrador de zona."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_CREATING_MANAGER_ZONE("Error creando el administrador de zona",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de creación de un nuevo administrador de zona."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_MANAGER_ZONE_ERROR_DAO_FINDING_ALL_MANAGER_ZONES("Problema consultando los administradores de zona",
	        "Se ha presentado un problema tratando de consultar la información de los administradores de zona. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_ALL_MANAGER_ZONES("Error consultando los administradores de zona",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de administradores de zona. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_MANAGER_ZONE_ERROR_DAO_FINDING_MANAGER_ZONE_BY_FILTER("Problema consultando los administradores de zona por filtro",
			"Se ha presentado un problema tratando de consultar la información de los administradores de zona según los criterios indicados. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_MANAGER_ZONE_BY_FILTER("Error consultando los administradores de zona por filtro",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de administradores de zona filtrados. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_MANAGER_ZONE_ERROR_DAO_FINDING_MANAGER_ZONE_BY_ID("Problema consultando el administrador de zona por su identificador",
	        "Se ha presentado un problema tratando de consultar la información del administrador de zona por su identificador."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_MANAGER_ZONE_BY_ID("Error consultando el administrador de zona por su identificador",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de un administrador de zona por su identificador."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_MANAGER_ZONE_ERROR_DAO_UPDATING_MANAGER_ZONE("Problema actualizando el administrador de zona",
	        "Se ha presentado un problema tratando de actualizar la información del administrador de zona."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_UPDATING_MANAGER_ZONE("Error actualizando el administrador de zona",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de actualización de la información del administrador de zona."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_MANAGER_ZONE_ERROR_DAO_DELETING_MANAGER_ZONE("Problema eliminando el administrador de zona",
			"Se ha presentado un problema tratando de eliminar la información del administrador de zona."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_DELETING_MANAGER_ZONE("Error eliminando el administrador de zona",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de eliminación de la información del administrador de zona."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_TYPE_ERROR_DAO_CREATING_CELL_TYPE("Problema creando el tipo de celda", 
			"Se ha presentado un problema tratando de registrar la información del nuevo tipo de celda."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_CREATING_CELL_TYPE("Error creando el tipo de celda",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de creación de un nuevo tipo de celda."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_TYPE_ERROR_DAO_FINDING_ALL_CELL_TYPES("Problema consultando los tipos de celda",
	        "Se ha presentado un problema tratando de consultar la información de los tipos de celda. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_ALL_CELL_TYPES("Error consultando los tipos de celda",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de tipos de celda. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_TYPE_ERROR_DAO_FINDING_CELL_TYPE_BY_FILTER("Problema consultando los tipos de celda por filtro",
			"Se ha presentado un problema tratando de consultar la información de los tipos de celda según los criterios indicados. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_CELL_TYPE_BY_FILTER("Error consultando los tipos de celda por filtro",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de tipos de celda filtrados. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_TYPE_ERROR_DAO_FINDING_CELL_TYPE_BY_ID("Problema consultando el tipo de celda por su identificador",
	        "Se ha presentado un problema tratando de consultar la información del tipo de celda por su identificador."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_CELL_TYPE_BY_ID("Error consultando el tipo de celda por su identificador",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de un tipo de celda por su identificador."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_TYPE_ERROR_DAO_UPDATING_CELL_TYPE("Problema actualizando el tipo de celda",
	        "Se ha presentado un problema tratando de actualizar la información del tipo de celda."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_UPDATING_CELL_TYPE("Error actualizando el tipo de celda",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de actualización de la información del tipo de celda."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_TYPE_ERROR_DAO_DELETING_CELL_TYPE("Problema eliminando el tipo de celda",
			"Se ha presentado un problema tratando de eliminar la información del tipo de celda."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_DELETING_CELL_TYPE("Error eliminando el tipo de celda",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de eliminación de la información del tipo de celda."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_ERROR_DAO_CREATING_CELL("Problema creando la celda", 
			"Se ha presentado un problema tratando de registrar la información de la nueva celda."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_CREATING_CELL("Error creando la celda",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de creación de una nueva celda."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_ERROR_DAO_FINDING_ALL_CELLS("Problema consultando las celdas",
	        "Se ha presentado un problema tratando de consultar la información de las celdas. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_ALL_CELLS("Error consultando las celdas",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de celdas. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_ERROR_DAO_FINDING_CELL_BY_FILTER("Problema consultando las celdas por filtro",
			"Se ha presentado un problema tratando de consultar la información de las celdas según los criterios indicados. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_CELL_BY_FILTER("Error consultando las celdas por filtro",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de celdas filtradas. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_ERROR_DAO_FINDING_CELL_BY_ID("Problema consultando la celda por su identificador",
			"Se ha presentado un problema tratando de consultar la información de la celda por su identificador."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_CELL_BY_ID("Error consultando la celda por su identificador",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de una celda por su identificador."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_ERROR_DAO_UPDATING_CELL("Problema actualizando la celda",
				        "Se ha presentado un problema tratando de actualizar la información de la celda."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_UPDATING_CELL("Error actualizando la celda",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de actualización de la información de la celda."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_ERROR_DAO_DELETING_CELL("Problema eliminando la celda",
			"Se ha presentado un problema tratando de eliminar la información de la celda."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_DELETING_CELL("Error eliminando la celda",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de eliminación de la información de la celda."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_VEHICLE_TYPE_ERROR_DAO_CREATING_VEHICLE_TYPE("Problema creando el tipo de vehículo", 
			"Se ha presentado un problema tratando de registrar la información del nuevo tipo de vehículo."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_CREATING_VEHICLE_TYPE("Error creando el tipo de vehículo",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de creación de un nuevo tipo de vehículo."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_VEHICLE_TYPE_ERROR_DAO_FINDING_ALL_VEHICLE_TYPES("Problema consultando los tipos de vehículo",
	        "Se ha presentado un problema tratando de consultar la información de los tipos de vehículo. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_ALL_VEHICLE_TYPES("Error consultando los tipos de vehículo",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de tipos de vehículo. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_VEHICLE_TYPE_ERROR_DAO_FINDING_BY_FILTER("Problema consultando los tipos de vehículo por filtro",
			"Se ha presentado un problema tratando de consultar la información de los tipos de vehículo según los criterios indicados. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_BY_FILTER("Error consultando los tipos de vehículo por filtro",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de tipos de vehículo filtrados. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_VEHICLE_TYPE_ERROR_DAO_FINDING_BY_ID("Problema consultando el tipo de vehículo por su identificador",
	        "Se ha presentado un problema tratando de consultar la información del tipo de vehículo por su identificador."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_BY_ID("Error consultando el tipo de vehículo por su identificador",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de un tipo de vehículo por su identificador."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_VEHICLE_TYPE_ERROR_DAO_UPDATING_VEHICLE_TYPE("Problema actualizando el tipo de vehículo",
			"Se ha presentado un problema tratando de actualizar la información del tipo de vehículo."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_UPDATING_VEHICLE_TYPE("Error actualizando el tipo de vehículo",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de actualización de la información del tipo de vehículo."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_VEHICLE_TYPE_ERROR_DAO_DELETING_VEHICLE_TYPE("Problema eliminando el tipo de vehículo",
			"Se ha presentado un problema tratando de eliminar la información del tipo de vehículo."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_DELETING_VEHICLE_TYPE("Error eliminando el tipo de vehículo",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de eliminación de la información del tipo de vehículo."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_VEHICLE_ERROR_DAO_CREATING_VEHICLE("Problema creando el vehículo", 
			"Se ha presentado un problema tratando de registrar la información del nuevo vehículo."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_CREATING_VEHICLE("Error creando el vehículo",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de creación de un nuevo vehículo."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_VEHICLE_ERROR_DAO_FINDING_ALL_VEHICLES("Problema consultando los vehículos",
	        "Se ha presentado un problema tratando de consultar la información de los vehículos. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_ALL_VEHICLES("Error consultando los vehículos",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de vehículos. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_VEHICLE_ERROR_DAO_FINDING_BY_FILTER("Problema consultando los vehículos por filtro",
			"Se ha presentado un problema tratando de consultar la información de los vehículos según los criterios indicados. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_VEHICLE_ERROR_DAO_FINDING_BY_FILTER("Error consultando los vehículos por filtro",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de vehículos filtrados. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_VEHICLE_ERROR_DAO_FINDING_BY_ID("Problema consultando el vehículo por su identificador",
	        "Se ha presentado un problema tratando de consultar la información del vehículo por su identificador."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_VEHICLE_ERROR_DAO_FINDING_BY_ID("Error consultando el vehículo por su identificador",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de un vehículo por su identificador."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_VEHICLE_ERROR_DAO_UPDATING_VEHICLE("Problema actualizando el vehículo",
				        "Se ha presentado un problema tratando de actualizar la información del vehículo."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_VEHICLE_ERROR_DAO_UPDATING_VEHICLE("Error actualizando el vehículo",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de actualización de la información del vehículo."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_VEHICLE_ERROR_DAO_DELETING_VEHICLE("Problema eliminando el vehículo",
			"Se ha presentado un problema tratando de eliminar la información del vehículo."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_VEHICLE_ERROR_DAO_DELETING_VEHICLE("Error eliminando el vehículo",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de eliminación de la información del vehículo."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_VEHICLE_ERROR_DAO_CREATING_CELL_VEHICLE("Problema creando la celda de vehículo", 
			"Se ha presentado un problema tratando de registrar la información de la nueva celda de vehículo."
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_CREATING_CELL_VEHICLE("Error creando la celda de vehículo",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de creación de una nueva celda de vehículo."
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_VEHICLE_ERROR_DAO_FINDING_ALL_CELL_VEHICLES("Problema consultando las celdas de vehículo",
	        "Se ha presentado un problema tratando de consultar la información de las celdas de vehículo. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_ALL_CELL_VEHICLES("Error consultando las celdas de vehículo",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de celdas de vehículo. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_VEHICLE_ERROR_DAO_FINDING_CELL_VEHICLE_BY_FILTER("Problema consultando las celdas de vehículo por filtro",
			"Se ha presentado un problema tratando de consultar la información de las celdas de vehículo según los criterios indicados. "
	        + "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_CELL_VEHICLE_BY_FILTER("Error consultando las celdas de vehículo por filtro",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de celdas de vehículo filtradas. "
	        + "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_VEHICLE_ERROR_DAO_FINDING_CELL_VEHICLE_BY_ID("Problema consultando la celda de vehículo por su identificador",
			"Se ha presentado un problema tratando de consultar la información de la celda de vehículo por su identificador."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_FINDING_CELL_VEHICLE_BY_ID("Error consultando la celda de vehículo por su identificador",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de consulta de una celda de vehículo por su identificador."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_VEHICLE_ERROR_DAO_UPDATING_CELL_VEHICLE("Problema actualizando la celda de vehículo",
				        "Se ha presentado un problema tratando de actualizar la información de la celda de vehículo."
				        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_UPDATING_CELL_VEHICLE("Error actualizando la celda de vehículo",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de actualización de la información de la celda de vehículo."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_VEHICLE_ERROR_DAO_DELETING_CELL_VEHICLE("Problema eliminando la celda de vehículo",
			"Se ha presentado un problema tratando de eliminar la información de la celda de vehículo."
	        + " Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_DAO_DELETING_CELL_VEHICLE("Error eliminando la celda de vehículo",
			"Se presentó un error de tipo SQLException al tratar de ejecutar el proceso de eliminación de la información de la celda de vehículo."
	        + " Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_CELL_TYPE_ALREADY_EXISTS("El tipo de celda ya existe",
			"Ya existe un tipo de celda registrado con el mismo nombre. Por favor verifique la información e intente de nuevo."),
	
	TECHNICAL_ERROR_CELL_TYPE_ALREADY_EXISTS("Error registrando el tipo de celda",
			"Ya existe un tipo de celda registrado con el mismo nombre en la base de datos."
			+ " Por favor verifique la información registrada e intente de nuevo."),
	
	USER_CELL_TYPE_ERROR_REGISTERING("Ocurrió un error al registrar el tipo de celda.",
			"Se presentó un problema al tratar de registrar el nuevo tipo de celda. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_CELL_TYPE_ERROR_REGISTERING("Error técnico al registrar el tipo de celda",
			"Se presentó un error técnico al tratar de registrar el nuevo tipo de celda en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_TYPE_UNEXPECTED_ERROR_REGISTERING("Ocurrió un error inesperado al registrar el tipo de celda.",
			"Se presentó un problema no controlado al tratar de registrar el nuevo tipo de celda. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_CELL_TYPE_UNEXPECTED_ERROR_REGISTERING("Error técnico inesperado al registrar el tipo de celda",
			"Se presentó un error técnico no controlado al tratar de registrar el nuevo tipo de celda en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_TYPE_ERROR_RETRIEVING_ALL_CELL_TYPE("Ocurrió un error al consultar los tipos de celda.",
			"Se presentó un problema al tratar de consultar la información de los tipos de celda. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_CELL_TYPE_ERROR_RETRIEVING_ALL_CELL_TYPE("Error técnico al consultar los tipos de celda",
			"Se presentó un error técnico al tratar de consultar la información de los tipos de celda en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_CELL_ERROR_BUSINESS_CELL_NOT_FOUND("Celda no encontrada",
			"La celda que intenta consultar no se encuentra registrada en el sistema. "
			+ "Por favor verifique la información e intente de nuevo."),
	
	TECHNICAL_ERROR_BUSINESS_CELL_NOT_FOUND("Error técnico consultando la celda",
			"La celda que se intenta consultar no se encuentra registrada en la base de datos. "
			+ "Por favor verifique la información registrada e intente de nuevo."),
	
	USER_CELL_UNEXPECTED_ERROR_BUSINESS_DELETING_CELL("Ocurrió un error inesperado al eliminar la celda.",
			"Se presentó un problema no controlado al tratar de eliminar la información de la celda. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_CELL_UNEXPECTED_ERROR_BUSINESS_DELETING_CELL("Error técnico inesperado al eliminar la celda",
			"Se presentó un error técnico no controlado al tratar de eliminar la información de la celda en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_FACADE_REGISTER_CELL_TYPE("Ocurrió un error al registrar el tipo de celda.",
			"Se presentó un problema al tratar de registrar el nuevo tipo de celda. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_FACADE_REGISTER_CELL_TYPE("Error técnico al registrar el tipo de celda",
			"Se presentó un error técnico al tratar de registrar el nuevo tipo de celda en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_FACADE_DROP_CELL_TYPE("Ocurrió un error al eliminar el tipo de celda.",
			"Se presentó un problema al tratar de eliminar el tipo de celda. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_FACADE_DROP_CELL_TYPE("Error técnico al eliminar el tipo de celda",
			"Se presentó un error técnico al tratar de eliminar el tipo de celda en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_FACADE_UPDATE_CELL_TYPE("Ocurrió un error al actualizar el tipo de celda.",
			"Se presentó un problema al tratar de actualizar el tipo de celda. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_FACADE_UPDATE_CELL_TYPE("Error técnico al actualizar el tipo de celda",
			"Se presentó un error técnico al tratar de actualizar el tipo de celda en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_FACADE_LIST_CELL_TYPES("Ocurrió un error al consultar los tipos de celda.",
			"Se presentó un problema al tratar de consultar la información de los tipos de celda. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_FACADE_LIST_CELL_TYPES("Error técnico al consultar los tipos de celda",
			"Se presentó un error técnico al tratar de consultar la información de los tipos de celda en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_FACADE_FILTER_CELL_TYPES_BY_FILTER("Ocurrió un error al consultar los tipos de celda por filtro.",
			"Se presentó un problema al tratar de consultar la información de los tipos de celda según los criterios indicados. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_FACADE_FILTER_CELL_TYPES_BY_FILTER("Error técnico al consultar los tipos de celda por filtro",
			"Se presentó un error técnico al tratar de consultar la información de los tipos de celda según los criterios indicados en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_FACADE_FIND_SPECIFIC_CELL_TYPE("Ocurrió un error al consultar el tipo de celda específico.",
			"Se presentó un problema al tratar de consultar la información del tipo de celda solicitado. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_FACADE_FIND_SPECIFIC_CELL_TYPE("Error técnico al consultar el tipo de celda específico",
			"Se presentó un error técnico al tratar de consultar la información del tipo de celda solicitado en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_FACADE_REGISTER_CELL("Ocurrió un error al registrar la celda.",
			"Se presentó un problema al tratar de registrar la nueva celda. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_FACADE_REGISTER_CELL("Error técnico al registrar la celda",
			"Se presentó un error técnico al tratar de registrar la nueva celda en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_FACADE_DROP_CELL("Ocurrió un error al eliminar la celda.",
			"Se presentó un problema al tratar de eliminar la celda. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_FACADE_DROP_CELL("Error técnico al eliminar la celda",
			"Se presentó un error técnico al tratar de eliminar la celda en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_FACADE_UPDATE_CELL("Ocurrió un error al actualizar la celda.",
			"Se presentó un problema al tratar de actualizar la celda. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_FACADE_UPDATE_CELL("Error técnico al actualizar la celda",
			"Se presentó un error técnico al tratar de actualizar la celda en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_FACADE_FIND_ALL_CELLS("Ocurrió un error al consultar las celdas.",
			"Se presentó un problema al tratar de consultar la información de las celdas. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_FACADE_FIND_ALL_CELLS("Error técnico al consultar las celdas",
			"Se presentó un error técnico al tratar de consultar la información de las celdas en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_FACADE_FIND_CELLS_BY_FILTER("Ocurrió un error al consultar las celdas por filtro.",
			"Se presentó un problema al tratar de consultar la información de las celdas según los criterios indicados. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_FACADE_FIND_CELLS_BY_FILTER("Error técnico al consultar las celdas por filtro",
			"Se presentó un error técnico al tratar de consultar la información de las celdas según los criterios indicados en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_FACADE_FIND_SPECIFIC_CELL("Ocurrió un error al consultar la celda específica.",
			"Se presentó un problema al tratar de consultar la información de la celda solicitada. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_FACADE_FIND_SPECIFIC_CELL("Error técnico al consultar la celda específica",
			"Se presentó un error técnico al tratar de consultar la información de la celda solicitada en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_FACADE_LIST_ZONES("Ocurrió un error al consultar las zonas de parqueo.",
			"Se presentó un problema al tratar de consultar la información de las zonas de parqueo. "
			+ "Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_FACADE_LIST_ZONES("Error técnico al consultar las zonas de parqueo",
			"Se presentó un error técnico al tratar de consultar la información de las zonas de parqueo en la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado.");
	
	private String title;
	private String content;
	
	private MessagesEnum(final String title, final String content) {
		setTitle(title);
		setContent(content);
	}

	public String getTitle() {
		return title;
	}

	private void setTitle(final String title) {
		this.title = TextHelper.getDefaultWithTrim(title);
	}

	public String getContent() {
		return content;
	}

	private void setContent(final String content) {
		this.content = TextHelper.getDefaultWithTrim(content);
	}
	
}
