import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}doctorScheduleManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}doctorScheduleManager/loadDoctorSchedule/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateDoctor = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}doctorScheduleManager/requestCandidateDoctor/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDoctor = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}doctorScheduleManager/transferToAnotherDoctor/id/anotherDoctorId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateExpenseType = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}doctorScheduleManager/requestCandidateExpenseType/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherExpenseType = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}doctorScheduleManager/transferToAnotherExpenseType/id/anotherExpenseTypeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateDepartment = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}doctorScheduleManager/requestCandidateDepartment/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDepartment = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}doctorScheduleManager/transferToAnotherDepartment/id/anotherDepartmentId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const DoctorScheduleService = { view,
  load,
  requestCandidateDoctor,
  requestCandidateExpenseType,
  requestCandidateDepartment,
  transferToAnotherDoctor,
  transferToAnotherExpenseType,
  transferToAnotherDepartment }
export default DoctorScheduleService

