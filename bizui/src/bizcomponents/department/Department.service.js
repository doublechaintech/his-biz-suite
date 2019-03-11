import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}departmentManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}departmentManager/loadDepartment/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateHospital = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}departmentManager/requestCandidateHospital/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherHospital = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}departmentManager/transferToAnotherHospital/id/anotherHospitalId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addDoctorAssignment = (targetObjectId, parameters) => {
  const url = `${PREFIX}departmentManager/addDoctorAssignment/departmentId/name/doctorId/tokensExpr/`
  const departmentId = targetObjectId
  const requestParameters = { ...parameters, departmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateDoctorAssignment = (targetObjectId, parameters) => {
  const url = `${PREFIX}departmentManager/updateDoctorAssignmentProperties/departmentId/id/name/tokensExpr/`
  const departmentId = targetObjectId
  const requestParameters = { ...parameters, departmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeDoctorAssignmentList = (targetObjectId, parameters) => {
  const url = `${PREFIX}departmentManager/removeDoctorAssignmentList/departmentId/doctorAssignmentIds/tokensExpr/`
  const requestParameters = { ...parameters, departmentId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addDoctorSchedule = (targetObjectId, parameters) => {
  const url = `${PREFIX}departmentManager/addDoctorSchedule/departmentId/name/scheduleDate/period/doctorId/available/price/expenseTypeId/tokensExpr/`
  const departmentId = targetObjectId
  const requestParameters = { ...parameters, departmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateDoctorSchedule = (targetObjectId, parameters) => {
  const url = `${PREFIX}departmentManager/updateDoctorScheduleProperties/departmentId/id/name/scheduleDate/period/available/price/tokensExpr/`
  const departmentId = targetObjectId
  const requestParameters = { ...parameters, departmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeDoctorScheduleList = (targetObjectId, parameters) => {
  const url = `${PREFIX}departmentManager/removeDoctorScheduleList/departmentId/doctorScheduleIds/tokensExpr/`
  const requestParameters = { ...parameters, departmentId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const DepartmentService = { view,
  load,
  addDoctorAssignment,
  addDoctorSchedule,
  updateDoctorAssignment,
  updateDoctorSchedule,
  removeDoctorAssignmentList,
  removeDoctorScheduleList,
  requestCandidateHospital,
  transferToAnotherHospital }
export default DepartmentService

