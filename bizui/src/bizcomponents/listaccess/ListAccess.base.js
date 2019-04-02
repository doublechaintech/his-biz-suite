import React from 'react'
import { Icon } from 'antd'
import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool';

const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"访问列表", menuFor: "listAccess",
  		subItems: [
  
  		],
}



const displayColumns = [
  { title: 'ID', debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: '内部名称', debugtype: 'string', dataIndex: 'internalName', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: '读权限', dataIndex: 'readPermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: '创建权限', dataIndex: 'createPermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: '删除权限', dataIndex: 'deletePermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: '更新许可', dataIndex: 'updatePermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: '执行权限', dataIndex: 'executionPermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: '应用程序', dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: 'ID',
  name: '名称',
  internalName: '内部名称',
  readPermission: '读权限',
  createPermission: '创建权限',
  deletePermission: '删除权限',
  updatePermission: '更新许可',
  executionPermission: '执行权限',
  app: '应用程序',

}


const ListAccessBase={menuData,displayColumns,fieldLabels}
export default ListAccessBase



