import ImagePreview from '../../components/ImagePreview';
import { Link } from 'dva/router';
import moment from 'moment';
import appLocaleName from '../../common/Locale.tool';

const menuData = {
  menuName: '费用项目',
  menuFor: 'expenseItem',
  subItems: [],
};

const renderTextCell = (value, record) => {
  const userContext = null;
  if (!value) {
    return '';
  }
  if (value == null) {
    return '';
  }
  if (value.length > 15) {
    return (
      value.substring(0, 15) + '...(' + value.length + appLocaleName(userContext, 'Chars') + ')'
    );
  }
  return value;
};

const renderIdentifier = (value, record, targtObjectType) => {
  return <Link to={`/${targtObjectType}/${value}/dashboard`}>{value}</Link>;
};

const renderDateCell = (value, record) => {
  return moment(value).format('YYYY-MM-DD');
};
const renderDateTimeCell = (value, record) => {
  return moment(value).format('YYYY-MM-DD HH:mm');
};

const renderImageCell = (value, record, title) => {
  return <ImagePreview imageTitle={title} imageLocation={value} />;
};

const formatMoney = amount => {
  const options = { style: 'decimal', minimumFractionDigits: 2, maximumFractionDigits: 2 };
  const moneyFormat = new Intl.NumberFormat('en-US', options);
  return moneyFormat.format(amount);
};

const renderMoneyCell = (value, record) => {
  const userContext = null;
  if (!value) {
    return appLocaleName(userContext, 'Empty');
  }
  if (value == null) {
    return appLocaleName(userContext, 'Empty');
  }
  return `${appLocaleName(userContext, 'Currency')}${formatMoney(value)}`;
};

const renderBooleanCell = (value, record) => {
  const userContext = null;

  return value ? appLocaleName(userContext, 'Yes') : appLocaleName(userContext, 'No');
};

const renderReferenceCell = (value, record) => {
  const userContext = null;
  return value ? value.displayName : appLocaleName(userContext, 'NotAssigned');
};

const displayColumns = [
  {
    title: 'ID',
    debugtype: 'string',
    dataIndex: 'id',
    width: '20',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: '名称',
    debugtype: 'string',
    dataIndex: 'name',
    width: '9',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: '价格',
    dataIndex: 'price',
    className: 'money',
    render: (text, record) => renderMoneyCell(text, record),
  },
  {
    title: '费用类型',
    dataIndex: 'expenseType',
    render: (text, record) => renderReferenceCell(text, record),
  },
  {
    title: '医院',
    dataIndex: 'hospital',
    render: (text, record) => renderReferenceCell(text, record),
  },
  {
    title: '更新时间',
    dataIndex: 'updateTime',
    render: (text, record) => renderDateTimeCell(text, record),
  },
];

const fieldLabels = {
  id: 'ID',
  name: '名称',
  price: '价格',
  expenseType: '费用类型',
  hospital: '医院',
  updateTime: '更新时间',
};

const ExpenseItemBase = { menuData, displayColumns, fieldLabels };
export default ExpenseItemBase;
