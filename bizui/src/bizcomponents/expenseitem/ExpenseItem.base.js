import React from 'react';
import { Icon, Divider } from 'antd';

import { Link } from 'dva/router';
import moment from 'moment';
import ImagePreview from '../../components/ImagePreview';
import appLocaleName from '../../common/Locale.tool';
import BaseTool from '../../common/Base.tool';
import GlobalComponents from '../../custcomponents';
import DescriptionList from '../../components/DescriptionList';
const { Description } = DescriptionList;
const {
  defaultRenderReferenceCell,
  defaultRenderBooleanCell,
  defaultRenderMoneyCell,
  defaultRenderDateTimeCell,
  defaultRenderImageCell,
  defaultRenderDateCell,
  defaultRenderIdentifier,
  defaultRenderTextCell,
} = BaseTool;

const renderTextCell = defaultRenderTextCell;
const renderIdentifier = defaultRenderIdentifier;
const renderDateCell = defaultRenderDateCell;
const renderDateTimeCell = defaultRenderDateTimeCell;
const renderImageCell = defaultRenderImageCell;
const renderMoneyCell = defaultRenderMoneyCell;
const renderBooleanCell = defaultRenderBooleanCell;
const renderReferenceCell = defaultRenderReferenceCell;

const menuData = {
  menuName: '费用项目',
  menuFor: 'expenseItem',
  subItems: [],
};

const fieldLabels = {
  id: 'ID',
  name: '名称',
  price: '价格',
  expenseType: '费用类型',
  hospital: '医院',
  updateTime: '更新时间',
};

const displayColumns = [
  {
    title: fieldLabels.id,
    debugtype: 'string',
    dataIndex: 'id',
    width: '8',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.name,
    debugtype: 'string',
    dataIndex: 'name',
    width: '9',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.price,
    dataIndex: 'price',
    className: 'money',
    render: (text, record) => renderMoneyCell(text, record),
    sorter: true,
  },
  {
    title: fieldLabels.expenseType,
    dataIndex: 'expenseType',
    render: (text, record) => renderReferenceCell(text, record),
    sorter: true,
  },
  {
    title: fieldLabels.hospital,
    dataIndex: 'hospital',
    render: (text, record) => renderReferenceCell(text, record),
    sorter: true,
  },
  {
    title: fieldLabels.updateTime,
    dataIndex: 'updateTime',
    render: (text, record) => renderDateTimeCell(text, record),
    sorter: true,
  },
];
// refernce to https://ant.design/components/list-cn/
const renderItemOfList = (expenseItem, targetComponent) => {
  const userContext = null;
  return (
    <div key={expenseItem.id}>
      <DescriptionList key={expenseItem.id} size="small" col="4">
        <Description term="ID">{expenseItem.id}</Description>
        <Description term="名称">{expenseItem.name}</Description>
        <Description term="价格">{expenseItem.price}</Description>
        <Description term="费用类型">
          {expenseItem.expenseType == null
            ? appLocaleName(userContext, 'NotAssigned')
            : `${expenseItem.expenseType.displayName}(${expenseItem.expenseType.id})`}
        </Description>
        <Description term="更新时间">
          {moment(expenseItem.updateTime).format('YYYY-MM-DD')}
        </Description>
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
  );
};

const ExpenseItemBase = { menuData, displayColumns, fieldLabels, renderItemOfList };
export default ExpenseItemBase;
