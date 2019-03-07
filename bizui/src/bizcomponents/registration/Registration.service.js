import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}registrationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}registrationManager/loadRegistration/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePatient = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}registrationManager/requestCandidatePatient/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPatient = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}registrationManager/transferToAnotherPatient/id/anotherPatientId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateRegister = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}registrationManager/requestCandidateRegister/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherRegister = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}registrationManager/transferToAnotherRegister/id/anotherRegisterId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}registrationManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}registrationManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const RegistrationService = { view,
  load,
  requestCandidatePatient,
  requestCandidateRegister,
  requestCandidatePlatform,
  transferToAnotherPatient,
  transferToAnotherRegister,
  transferToAnotherPlatform }
export default RegistrationService

