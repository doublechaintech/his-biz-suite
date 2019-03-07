import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}platformManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}platformManager/loadPlatform/${targetObjectId}/${parametersExpr}/`,
  })
}







const addDoctor = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addDoctor/platformId/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateDoctor = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateDoctorProperties/platformId/id/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeDoctorList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeDoctorList/platformId/doctorIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addProfile = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addProfile/platformId/name/gender/age/identificationNumber/mobile/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProfile = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateProfileProperties/platformId/id/name/gender/age/identificationNumber/mobile/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProfileList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeProfileList/platformId/profileIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRegistration = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addRegistration/platformId/title/patientId/registerId/content/status/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRegistration = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateRegistrationProperties/platformId/id/title/content/status/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRegistrationList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeRegistrationList/platformId/registrationIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const PlatformService = { view,
  load,
  addDoctor,
  addProfile,
  addRegistration,
  updateDoctor,
  updateProfile,
  updateRegistration,
  removeDoctorList,
  removeProfileList,
  removeRegistrationList }
export default PlatformService

