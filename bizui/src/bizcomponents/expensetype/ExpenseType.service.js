
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}expenseTypeManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}expenseTypeManager/loadExpenseType/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateHospital = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}expenseTypeManager/requestCandidateHospital/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherHospital = (id, parameters) => {
  const url = `${PREFIX}expenseTypeManager/transferToAnotherHospital/id/anotherHospitalId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addExpenseItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}expenseTypeManager/addExpenseItem/expenseTypeId/name/price/hospitalId/tokensExpr/`
  const expenseTypeId = targetObjectId
  const requestParameters = { ...parameters, expenseTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateExpenseItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}expenseTypeManager/updateExpenseItemProperties/expenseTypeId/id/name/price/tokensExpr/`
  const expenseTypeId = targetObjectId
  const requestParameters = { ...parameters, expenseTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeExpenseItemList = (targetObjectId, parameters) => {
  const url = `${PREFIX}expenseTypeManager/removeExpenseItemList/expenseTypeId/expenseItemIds/tokensExpr/`
  const requestParameters = { ...parameters, expenseTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addDoctorSchedule = (targetObjectId, parameters) => {
  const url = `${PREFIX}expenseTypeManager/addDoctorSchedule/expenseTypeId/name/doctorId/scheduleDate/periodId/departmentId/available/price/hospitalId/tokensExpr/`
  const expenseTypeId = targetObjectId
  const requestParameters = { ...parameters, expenseTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateDoctorSchedule = (targetObjectId, parameters) => {
  const url = `${PREFIX}expenseTypeManager/updateDoctorScheduleProperties/expenseTypeId/id/name/scheduleDate/available/price/tokensExpr/`
  const expenseTypeId = targetObjectId
  const requestParameters = { ...parameters, expenseTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeDoctorScheduleList = (targetObjectId, parameters) => {
  const url = `${PREFIX}expenseTypeManager/removeDoctorScheduleList/expenseTypeId/doctorScheduleIds/tokensExpr/`
  const requestParameters = { ...parameters, expenseTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}expenseTypeService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}expenseTypeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}expenseTypeService/process/`,
    data,
  })
}

const ExpenseTypeService = { view,
  load,
  addExpenseItem,
  addDoctorSchedule,
  updateExpenseItem,
  updateDoctorSchedule,
  removeExpenseItemList,
  removeDoctorScheduleList,
  requestCandidateHospital,
  transferToAnotherHospital, listFunctions, saveRequest, processRequest}
export default ExpenseTypeService

