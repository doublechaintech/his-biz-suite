import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}profileManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}profileManager/loadProfile/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}profileManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}profileManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addRegistrationAsPatient = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addRegistrationAsPatient/profileId/title/content/status/platformId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRegistrationAsPatient = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateRegistrationAsPatientProperties/profileId/id/title/content/status/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRegistrationListAsPatient = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeRegistrationListAsPatient/profileId/registrationIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRegistrationAsRegister = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addRegistrationAsRegister/profileId/title/content/status/platformId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRegistrationAsRegister = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateRegistrationAsRegisterProperties/profileId/id/title/content/status/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRegistrationListAsRegister = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeRegistrationListAsRegister/profileId/registrationIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const ProfileService = { view,
  load,
  addRegistrationAsPatient,
  addRegistrationAsRegister,
  updateRegistrationAsPatient,
  updateRegistrationAsRegister,
  removeRegistrationListAsPatient,
  removeRegistrationListAsRegister,
  requestCandidatePlatform,
  transferToAnotherPlatform }
export default ProfileService

