import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}periodManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}periodManager/loadPeriod/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateHospital = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}periodManager/requestCandidateHospital/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherHospital = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}periodManager/transferToAnotherHospital/id/anotherHospitalId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addDoctorSchedule = (targetObjectId, parameters) => {
  const url = `${PREFIX}periodManager/addDoctorSchedule/periodId/name/doctorId/scheduleDate/departmentId/available/price/expenseTypeId/hospitalId/tokensExpr/`
  const periodId = targetObjectId
  const requestParameters = { ...parameters, periodId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateDoctorSchedule = (targetObjectId, parameters) => {
  const url = `${PREFIX}periodManager/updateDoctorScheduleProperties/periodId/id/name/scheduleDate/available/price/tokensExpr/`
  const periodId = targetObjectId
  const requestParameters = { ...parameters, periodId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeDoctorScheduleList = (targetObjectId, parameters) => {
  const url = `${PREFIX}periodManager/removeDoctorScheduleList/periodId/doctorScheduleIds/tokensExpr/`
  const requestParameters = { ...parameters, periodId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const PeriodService = { view,
  load,
  addDoctorSchedule,
  updateDoctorSchedule,
  removeDoctorScheduleList,
  requestCandidateHospital,
  transferToAnotherHospital }
export default PeriodService

