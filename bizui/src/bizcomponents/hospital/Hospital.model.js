import pathToRegexp from 'path-to-regexp';
import { routerRedux } from 'dva/router';
import { notification } from 'antd';
import GlobalComponents from '../../custcomponents';
import appLocaleName from '../../common/Locale.tool';
import modeltool from '../../utils/modeltool';
const {
  setupModel,
  hasError,
  handleClientError,
  handleServerError,
  keepValueWithKeySuffix,
} = modeltool;

const notifySuccess = userContext => {
  notification.success({
    message: appLocaleName(userContext, 'Success'),
    description: appLocaleName(userContext, 'Success'),
  });
};

export default {
  namespace: '_hospital',

  state: {},

  subscriptions: {
    setup({ dispatch, history }) {
      history.listen(location => {
        const modelName = 'hospital';
        const parameter = { dispatch, history, location, modelName };
        //console.log("setupModel",setupModel,typeof(setupModel))
        setupModel(parameter);
      });
    },
  },
  effects: {
    *view({ payload }, { call, put, select }) {
      const cachedData = yield select(state => state._hospital);
      //if the data in the cache, just show it, there is no delay
      const link = payload.pathname;
      //if the data in the cache, just show it, there is no delay
      if (cachedData.class) {
        //yield put({ type: 'breadcrumb/gotoLink', payload: { displayName:cachedData.displayName,link }} )
        yield put({ type: 'updateState', payload: cachedData });

        if (payload.useCache) {
          return; //use cache for returning page
        }
      } else {
        yield put({ type: 'showLoading', payload });
      }

      const { HospitalService } = GlobalComponents;
      const data = yield call(HospitalService.view, payload.id);

      const displayName = payload.displayName || data.displayName;

      yield put({ type: 'breadcrumb/gotoLink', payload: { displayName, link } });

      yield put({ type: 'updateState', payload: data });
    },
    *load({ payload }, { call, put }) {
      const { HospitalService } = GlobalComponents;
      //yield put({ type: 'showLoading', payload })
      const data = yield call(HospitalService.load, payload.id, payload.parameters);
      const newPlayload = { ...payload, ...data };

      console.log('this is the data id: ', data.id);
      yield put({ type: 'updateState', payload: newPlayload });
    },

    *doJob({ payload }, { call, put }) {
      const userContext = null;
      const { TaskService } = GlobalComponents;
      //yield put({ type: 'showLoading', payload })
      const { serviceNameToCall, id, parameters } = payload;
      if (!serviceNameToCall) {
        handleClientError(appLocaleName(userContext, 'ServiceNotRegistered'));
        return;
      }
      ('react/dva_object_model.jsp');

      const data = yield call(serviceNameToCall, id, parameters);
      if (handleServerError(data)) {
        return;
      }
      const newPlayload = { ...payload, ...data };

      console.log('this is the data id: ', data.id);
      yield put({ type: 'updateState', payload: newPlayload });
    },

    *gotoCreateForm({ payload }, { put }) {
      const { id, role } = payload;
      yield put(routerRedux.push(`/hospital/${id}/list/${role}CreateForm`));
    },
    *gotoUpdateForm({ payload }, { put }) {
      const { id, role, selectedRows, currentUpdateIndex } = payload;
      const state = { id, role, selectedRows, currentUpdateIndex };
      const location = { pathname: `/hospital/${id}/list/${role}UpdateForm`, state };
      yield put(routerRedux.push(location));
    },
    *goback({ payload }, { put }) {
      const { id, type, listName } = payload;
      yield put(routerRedux.push(`/hospital/${id}/list/${type}List/${listName}`));
    },

    *addExpenseType({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.addExpenseType, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/hospital/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
<<<<<<< HEAD
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/hospital/${id}/list/\ExpenseTypeList/费用类型+${appLocaleName(
          userContext,
          'List'
        )}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
=======
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/hospital/${id}/list/\ExpenseTypeList/费用类型+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
    },
    *updateExpenseType({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.updateExpenseType, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const partialList = true;

      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex, partialList };
      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);

      if (continueNext) {
        return;
      }
<<<<<<< HEAD
      const location = {
        pathname: `/hospital/${id}/list/\ExpenseTypeList/费用类型列表`,
        state: newPlayload,
      };
      yield put(routerRedux.push(location));
=======
      const location = { pathname: `/hospital/${id}/list/\ExpenseTypeList/费用类型列表`, state: newPlayload }
      yield put(routerRedux.push(location))
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
    },
    *gotoNextExpenseTypeUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeExpenseTypeList({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.removeExpenseTypeList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },

    *addPeriod({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.addPeriod, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/hospital/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/hospital/${id}/list/\PeriodList/期+${appLocaleName(userContext, 'List')}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
    },
    *updatePeriod({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.updatePeriod, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const partialList = true;

      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex, partialList };
      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);

      if (continueNext) {
        return;
      }
      const location = { pathname: `/hospital/${id}/list/\PeriodList/期列表`, state: newPlayload };
      yield put(routerRedux.push(location));
    },
    *gotoNextPeriodUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removePeriodList({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.removePeriodList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },

    *addExpenseItem({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.addExpenseItem, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/hospital/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
<<<<<<< HEAD
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/hospital/${id}/list/\ExpenseItemList/费用项目+${appLocaleName(
          userContext,
          'List'
        )}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
=======
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/hospital/${id}/list/\ExpenseItemList/费用项目+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
    },
    *updateExpenseItem({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.updateExpenseItem, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const partialList = true;

      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex, partialList };
      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);

      if (continueNext) {
        return;
      }
<<<<<<< HEAD
      const location = {
        pathname: `/hospital/${id}/list/\ExpenseItemList/费用项目列表`,
        state: newPlayload,
      };
      yield put(routerRedux.push(location));
=======
      const location = { pathname: `/hospital/${id}/list/\ExpenseItemList/费用项目列表`, state: newPlayload }
      yield put(routerRedux.push(location))
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
    },
    *gotoNextExpenseItemUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeExpenseItemList({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.removeExpenseItemList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },

    *addDoctor({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.addDoctor, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/hospital/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
<<<<<<< HEAD
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/hospital/${id}/list/\DoctorList/医生+${appLocaleName(userContext, 'List')}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
=======
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/hospital/${id}/list/\DoctorList/医生+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
    },
    *updateDoctor({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.updateDoctor, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const partialList = true;

      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex, partialList };
      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);

      if (continueNext) {
        return;
      }
<<<<<<< HEAD
      const location = {
        pathname: `/hospital/${id}/list/\DoctorList/医生列表`,
        state: newPlayload,
      };
      yield put(routerRedux.push(location));
=======
      const location = { pathname: `/hospital/${id}/list/\DoctorList/医生列表`, state: newPlayload }
      yield put(routerRedux.push(location))
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
    },
    *gotoNextDoctorUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeDoctorList({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.removeDoctorList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },

    *addDepartment({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.addDepartment, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/hospital/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
<<<<<<< HEAD
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/hospital/${id}/list/\DepartmentList/部门+${appLocaleName(userContext, 'List')}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
=======
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/hospital/${id}/list/\DepartmentList/部门+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
    },
    *updateDepartment({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.updateDepartment, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const partialList = true;

      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex, partialList };
      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);

      if (continueNext) {
        return;
      }
<<<<<<< HEAD
      const location = {
        pathname: `/hospital/${id}/list/\DepartmentList/部门列表`,
        state: newPlayload,
      };
      yield put(routerRedux.push(location));
=======
      const location = { pathname: `/hospital/${id}/list/\DepartmentList/部门列表`, state: newPlayload }
      yield put(routerRedux.push(location))
>>>>>>> f0fec7af5ee3d5cf047fe422adb18787dcd4aa89
    },
    *gotoNextDepartmentUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeDepartmentList({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.removeDepartmentList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },

    *addDoctorSchedule({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.addDoctorSchedule, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/hospital/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/hospital/${id}/list/\DoctorScheduleList/医生安排+${appLocaleName(
          userContext,
          'List'
        )}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
    },
    *updateDoctorSchedule({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.updateDoctorSchedule, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const partialList = true;

      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex, partialList };
      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);

      if (continueNext) {
        return;
      }
      const location = {
        pathname: `/hospital/${id}/list/\DoctorScheduleList/医生安排列表`,
        state: newPlayload,
      };
      yield put(routerRedux.push(location));
    },
    *gotoNextDoctorScheduleUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeDoctorScheduleList({ payload }, { call, put }) {
      const userContext = null;
      const { HospitalService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HospitalService.removeDoctorScheduleList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },
  },

  reducers: {
    updateState(state, action) {
      const payload = { ...action.payload, loading: true };
      const valueToKeep = keepValueWithKeySuffix(state, 'Parameters');
      return { ...valueToKeep, ...payload };
    },
    showLoading(state, action) {
      // const loading=true
      const payload = { ...action.payload, loading: true };
      const valueToKeep = keepValueWithKeySuffix(state, 'Parameters');
      return { ...valueToKeep, ...payload };
    },
  },
};
