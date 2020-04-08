
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}doctorManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}doctorManager/loadDoctor/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateHospital = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}doctorManager/requestCandidateHospital/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherHospital = (id, parameters) => {
  const url = `${PREFIX}doctorManager/transferToAnotherHospital/id/anotherHospitalId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addDoctorAssignment = (targetObjectId, parameters) => {
  const url = `${PREFIX}doctorManager/addDoctorAssignment/doctorId/name/departmentId/tokensExpr/`
  const doctorId = targetObjectId
  const requestParameters = { ...parameters, doctorId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateDoctorAssignment = (targetObjectId, parameters) => {
  const url = `${PREFIX}doctorManager/updateDoctorAssignmentProperties/doctorId/id/name/tokensExpr/`
  const doctorId = targetObjectId
  const requestParameters = { ...parameters, doctorId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeDoctorAssignmentList = (targetObjectId, parameters) => {
  const url = `${PREFIX}doctorManager/removeDoctorAssignmentList/doctorId/doctorAssignmentIds/tokensExpr/`
  const requestParameters = { ...parameters, doctorId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addDoctorSchedule = (targetObjectId, parameters) => {
  const url = `${PREFIX}doctorManager/addDoctorSchedule/doctorId/name/scheduleDate/periodId/departmentId/available/price/expenseTypeId/hospitalId/tokensExpr/`
  const doctorId = targetObjectId
  const requestParameters = { ...parameters, doctorId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateDoctorSchedule = (targetObjectId, parameters) => {
  const url = `${PREFIX}doctorManager/updateDoctorScheduleProperties/doctorId/id/name/scheduleDate/available/price/tokensExpr/`
  const doctorId = targetObjectId
  const requestParameters = { ...parameters, doctorId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeDoctorScheduleList = (targetObjectId, parameters) => {
  const url = `${PREFIX}doctorManager/removeDoctorScheduleList/doctorId/doctorScheduleIds/tokensExpr/`
  const requestParameters = { ...parameters, doctorId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}doctorService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}doctorService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}doctorService/process/`,
    data,
  })
}

const DoctorService = { view,
  load,
  addDoctorAssignment,
  addDoctorSchedule,
  updateDoctorAssignment,
  updateDoctorSchedule,
  removeDoctorAssignmentList,
  removeDoctorScheduleList,
  requestCandidateHospital,
  transferToAnotherHospital, listFunctions, saveRequest, processRequest}
export default DoctorService

