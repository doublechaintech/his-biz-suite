import React from 'react';
import { Router, Route, Switch } from 'dva/router';
import { LocaleProvider } from 'antd';
import zhCN from 'antd/lib/locale-provider/zh_CN';
// import enUS from 'antd/lib/locale-provider/en_US'
import Launcher from '../launcher/Launcher';
import ForgetPasswordForm from '../launcher/ForgetPasswordForm';

import GlobalComponents from './';

function RouterConfig({ history }) {}

export default RouterConfig;
