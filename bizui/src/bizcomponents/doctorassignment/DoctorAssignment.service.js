
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}doctorAssignmentManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}doctorAssignmentManager/loadDoctorAssignment/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateDoctor = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}doctorAssignmentManager/requestCandidateDoctor/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDoctor = (id, parameters) => {
  const url = `${PREFIX}doctorAssignmentManager/transferToAnotherDoctor/id/anotherDoctorId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateDepartment = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}doctorAssignmentManager/requestCandidateDepartment/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDepartment = (id, parameters) => {
  const url = `${PREFIX}doctorAssignmentManager/transferToAnotherDepartment/id/anotherDepartmentId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}doctorAssignmentService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}doctorAssignmentService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}doctorAssignmentService/process/`,
    data,
  })
}

const DoctorAssignmentService = { view,
  load,
  requestCandidateDoctor,
  requestCandidateDepartment,
  transferToAnotherDoctor,
  transferToAnotherDepartment, listFunctions, saveRequest, processRequest}
export default DoctorAssignmentService

