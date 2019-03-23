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



const addPeriod = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/addPeriod/hospitalId/name/tokensExpr/`
  const hospitalId = targetObjectId
  const requestParameters = { ...parameters, hospitalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updatePeriod = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/updatePeriodProperties/hospitalId/id/name/tokensExpr/`
  const hospitalId = targetObjectId
  const requestParameters = { ...parameters, hospitalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removePeriodList = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/removePeriodList/hospitalId/periodIds/tokensExpr/`
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
  const url = `${PREFIX}hospitalManager/addDoctor/hospitalId/name/shotImage/tokensExpr/`
  const hospitalId = targetObjectId
  const requestParameters = { ...parameters, hospitalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateDoctor = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/updateDoctorProperties/hospitalId/id/name/shotImage/tokensExpr/`
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



const addDoctorSchedule = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/addDoctorSchedule/hospitalId/name/doctorId/scheduleDate/periodId/departmentId/available/price/expenseTypeId/tokensExpr/`
  const hospitalId = targetObjectId
  const requestParameters = { ...parameters, hospitalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateDoctorSchedule = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/updateDoctorScheduleProperties/hospitalId/id/name/scheduleDate/available/price/tokensExpr/`
  const hospitalId = targetObjectId
  const requestParameters = { ...parameters, hospitalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeDoctorScheduleList = (targetObjectId, parameters) => {
  const url = `${PREFIX}hospitalManager/removeDoctorScheduleList/hospitalId/doctorScheduleIds/tokensExpr/`
  const requestParameters = { ...parameters, hospitalId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const HospitalService = { view,
  load,
  addExpenseType,
  addPeriod,
  addExpenseItem,
  addDoctor,
  addDepartment,
  addDoctorSchedule,
  updateExpenseType,
  updatePeriod,
  updateExpenseItem,
  updateDoctor,
  updateDepartment,
  updateDoctorSchedule,
  removeExpenseTypeList,
  removePeriodList,
  removeExpenseItemList,
  removeDoctorList,
  removeDepartmentList,
  removeDoctorScheduleList }
export default HospitalService

