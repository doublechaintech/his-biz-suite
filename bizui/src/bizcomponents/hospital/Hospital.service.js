import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}hospitalManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}hospitalManager/loadHospital/${targetObjectId}/${parametersExpr}/`,
  })
}







const addExpenseType = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/addExpenseType/hospitalId/name/helperChars/status/description/tokensExpr/`
  const hospitalId = targetObjectId
  const requestParameters = { ...parameters, hospitalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateExpenseType = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/updateExpenseTypeProperties/hospitalId/id/name/helperChars/status/description/tokensExpr/`
  const hospitalId = targetObjectId
  const requestParameters = { ...parameters, hospitalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeExpenseTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/removeExpenseTypeList/hospitalId/expenseTypeIds/tokensExpr/`
  const requestParameters = { ...parameters, hospitalId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addExpenseItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/addExpenseItem/hospitalId/name/price/expenseTypeId/tokensExpr/`
  const hospitalId = targetObjectId
  const requestParameters = { ...parameters, hospitalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateExpenseItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/updateExpenseItemProperties/hospitalId/id/name/price/tokensExpr/`
  const hospitalId = targetObjectId
  const requestParameters = { ...parameters, hospitalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeExpenseItemList = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/removeExpenseItemList/hospitalId/expenseItemIds/tokensExpr/`
  const requestParameters = { ...parameters, hospitalId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addDoctor = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/addDoctor/hospitalId/name/tokensExpr/`
  const hospitalId = targetObjectId
  const requestParameters = { ...parameters, hospitalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateDoctor = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/updateDoctorProperties/hospitalId/id/name/tokensExpr/`
  const hospitalId = targetObjectId
  const requestParameters = { ...parameters, hospitalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeDoctorList = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/removeDoctorList/hospitalId/doctorIds/tokensExpr/`
  const requestParameters = { ...parameters, hospitalId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addDepartment = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/addDepartment/hospitalId/name/tokensExpr/`
  const hospitalId = targetObjectId
  const requestParameters = { ...parameters, hospitalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateDepartment = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/updateDepartmentProperties/hospitalId/id/name/tokensExpr/`
  const hospitalId = targetObjectId
  const requestParameters = { ...parameters, hospitalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeDepartmentList = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/removeDepartmentList/hospitalId/departmentIds/tokensExpr/`
  const requestParameters = { ...parameters, hospitalId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const HospitalService = { view,
  load,
  addExpenseType,
  addExpenseItem,
  addDoctor,
  addDepartment,
  updateExpenseType,
  updateExpenseItem,
  updateDoctor,
  updateDepartment,
  removeExpenseTypeList,
  removeExpenseItemList,
  removeDoctorList,
  removeDepartmentList }
export default HospitalService

