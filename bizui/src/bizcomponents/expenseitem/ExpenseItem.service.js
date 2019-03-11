import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}expenseItemManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}expenseItemManager/loadExpenseItem/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateExpenseType = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}expenseItemManager/requestCandidateExpenseType/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherExpenseType = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}expenseItemManager/transferToAnotherExpenseType/id/anotherExpenseTypeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateHospital = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}expenseItemManager/requestCandidateHospital/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherHospital = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}expenseItemManager/transferToAnotherHospital/id/anotherHospitalId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const ExpenseItemService = { view,
  load,
  requestCandidateExpenseType,
  requestCandidateHospital,
  transferToAnotherExpenseType,
  transferToAnotherHospital }
export default ExpenseItemService

