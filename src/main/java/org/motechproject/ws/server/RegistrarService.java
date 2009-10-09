package org.motechproject.ws.server;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.motechproject.ws.ContactNumberType;
import org.motechproject.ws.Gender;
import org.motechproject.ws.LogType;
import org.motechproject.ws.MediaType;

/**
 * The service endpoint interface for the major motech server web service
 * endpoint. The annotations allow for minimal configuration deployment of
 * JAX-WS enpoints and clients, with appropriate behavior and metadata.
 */
@WebService
public interface RegistrarService {

	@WebMethod
	public void registerClinic(@WebParam(name = "name") String name);

	@WebMethod
	public void registerNurse(@WebParam(name = "name") String name,
			@WebParam(name = "phoneNumber") String phoneNumber,
			@WebParam(name = "clinic") String clinic);

	@WebMethod
	public void registerPatient(
			@WebParam(name = "nursePhoneNumber") String nursePhoneNumber,
			@WebParam(name = "serialId") String serialId,
			@WebParam(name = "name") String name,
			@WebParam(name = "community") String community,
			@WebParam(name = "location") String location,
			@WebParam(name = "dateOfBirth") Date dateOfBirth,
			@WebParam(name = "gender") Gender gender,
			@WebParam(name = "nhis") Integer nhis,
			@WebParam(name = "phoneNumber") String phoneNumber,
			@WebParam(name = "contactNumberType") ContactNumberType contactNumberType,
			@WebParam(name = "language") String language,
			@WebParam(name = "mediaType") MediaType mediaType);

	@WebMethod
	public void recordMaternalVisit(
			@WebParam(name = "nursePhoneNumber") String nursePhoneNumber,
			@WebParam(name = "date") Date date,
			@WebParam(name = "serialId") String serialId,
			@WebParam(name = "tetanus") Boolean tetanus,
			@WebParam(name = "ipt") Boolean ipt,
			@WebParam(name = "itn") Boolean itn,
			@WebParam(name = "visitNumber") Integer visitNumber,
			@WebParam(name = "onARV") Boolean onARV,
			@WebParam(name = "prePMTCT") Boolean prePMTCT,
			@WebParam(name = "testPMTCT") Boolean testPMTCT,
			@WebParam(name = "postPMTCT") Boolean postPMTCT,
			@WebParam(name = "hemoglobinAt36Weeks") Double hemoglobinAt36Weeks);

	@WebMethod
	public void registerPregnancy(
			@WebParam(name = "nursePhoneNumber") String nursePhoneNumber,
			@WebParam(name = "date") Date date,
			@WebParam(name = "serialId") String serialId,
			@WebParam(name = "dueDate") Date dueDate,
			@WebParam(name = "parity") Integer parity,
			@WebParam(name = "hemoglobin") Double hemoglobin);

	@WebMethod
	public void log(@WebParam(name = "type") LogType type,
			@WebParam(name = "message") String message);

	@WebMethod
	public void setMessageStatus(
			@WebParam(name = "messageId") String messageId,
			@WebParam(name = "success") Boolean success);
}
