
import React, { PureComponent } from 'react';
import { connect } from 'dva';
import Result from '../../components/Result';

import { Row, Col, Card, Form, Input, Select, Icon, Button, Dropdown, Menu, InputNumber, DatePicker, Modal, message } from 'antd';
import CommunityTable from './Community.table';
import CommunityConfirmationTable from './Community.confirmmationtable';

import CommunitySearchForm from './Community.searchform';

import PageHeaderLayout from '../../layouts/PageHeaderLayout';

import styles from './Community.search.less';

const FormItem = Form.Item;
const { Option } = Select;
const getValue = obj => Object.keys(obj).map(key => obj[key]).join(',');


@Form.create()
export default class CommunitySearch extends PureComponent {
  state = {
    addInputValue: '',
    modalVisible: false,
    // expandForm: false,
    selectedRows: [],
    formValues: {},
    showDeleteResult: false,
  };

  //  componentDidMount() {
  //    const { dispatch } = this.props;
  //  }

  handleStandardTableChange = (pagination, filtersArg, sorter) => {
    const { dispatch } = this.props;
    const { formValues } = this.state;

    const filters = Object.keys(filtersArg).reduce((obj, key) => {
      const newObj = { ...obj };
      newObj[key] = getValue(filtersArg[key]);
      return newObj;
    }, {});

    const params = {
      communityList: 1,
      communityListCurrentPage: pagination.current,
      communityListRowsPerPage: pagination.pageSize,
      ...formValues,
      ...filters,
    };
    if (sorter.field) {
      params.sorter = '_';
    }
    const { owner } = this.props;
    dispatch({
      type: `${owner.type}/load`,
      payload: { id: owner.id, parameters: params },
    });
  }

  handleMenuClick = (e) => {
    const { dispatch } = this.props;
    const { selectedRows } = this.state;
    if (!selectedRows) return;
    switch (e.key) {
      case 'remove':
        dispatch({
          type: 'rule/remove',
          payload: {
            no: selectedRows.map(row => row.no).join(','),
          },
          callback: () => {
            this.setState({
              selectedRows: [],
            });
          },
        });
        break;
      default:
        break;
    }
  }

  handleSelectRows = (rows) => {
    this.setState({
      selectedRows: rows,
    });
  }

  handleModalVisible = (flag) => {
    this.setState({
      modalVisible: !!flag,
      showDeleteResult: false,
    });
  }

  handleDelete = () => {
    const { selectedRows } = this.state;
    const { dispatch, owner } = this.props;
    console.log('things to delete', selectedRows);
    this.setState({
      modalVisible: true,
      showDeleteResult: true,
    });
    
    const communityIds = selectedRows.map((item) => { return item.id; });
    console.log('communityIds', communityIds);
    const parameters = { communityIds };
    dispatch({
      type: `${owner.type}/removeCommunityList`,
      payload: { id: owner.id, type: 'community', parameters },
    });
  }
  
  showModal = () => {
    // const { selectedRows } = this.state;
    // const { dispatch, owner } = this.props;
    this.setState({
      modalVisible: true,
      showDeleteResult: false,
    });
  }

  confirmAfterDelete = () => {
    // const { selectedRows } = this.state;
    // const { dispatch, owner } = this.props;
    this.setState({
      modalVisible: false,
      showDeleteResult: true,
    });
  }

  handleCreate = () => {
    const { dispatch, owner } = this.props;
    dispatch({
      type: `${owner.type}/gotoCreateForm`,
      payload: { id: owner.id, type: 'community' },
    });
  }

  handleUpdate = () => {
    const { dispatch, owner } = this.props;
    // const { showDeleteResult, selectedRows, modalVisible, addInputValue } = this.state;
    const { selectedRows } = this.state;
    const currentUpdateIndex = 0;
    dispatch({
      type: `${owner.type}/gotoUpdateForm`,
      payload: { id: owner.id, type: 'community', selectedRows, currentUpdateIndex },
    });
  }
  
  handleAddInput = (e) => {
    this.setState({
      addInputValue: e.target.value,
    });
  }

  handleAdd = () => {
    this.props.dispatch({
      type: 'rule/add',
      payload: {
        description: this.state.addInputValue,
      },
    });
    message.success('添加成功');
    this.setState({
      modalVisible: false,
    });
  }

  render() {
    const { data, loading, count, currentPage, owner } = this.props;
    const { showDeleteResult, selectedRows, modalVisible } = this.state;
    // const { showDeleteResult, selectedRows, modalVisible, addInputValue } = this.state;
    const menu = (
      <Menu onClick={this.handleMenuClick} selectedKeys={[]}>
        <Menu.Item key="remove">删除</Menu.Item>
        <Menu.Item key="approval">批量审批</Menu.Item>
      </Menu>
    );

    // TODO some issue here
    const modalContent = (data, owner) => {
      if (showDeleteResult) {
        return (
        <Modal
          title="成功删除"
          visible={modalVisible}
          onOk={() => this.confirmAfterDelete()}
          onCancel={() => this.confirmAfterDelete()}
          width={920}
          style={{ top: 40 }}
        >
          <Result type="success" title="删除成功，干得漂亮" description="" style={{ marginTop: 48, marginBottom: 16 }} />
        </Modal>);
      }

      return (
        <Modal
          title="注意！你正在删除数据，执行之后不可恢复"
          visible={modalVisible}
          onOk={this.handleDelete}
          onCancel={() => this.handleModalVisible()}
          width={920}
          style={{ top: 40 }}
        >
          <CommunityConfirmationTable data={selectedRows} owner={owner} />
        </Modal>);
    };
    
    return (
      <PageHeaderLayout title="社区列表">
        <Card bordered={false}>
          <div className={styles.tableList}>
            <div className={styles.tableListForm}>
              <CommunitySearchForm {...this.props} />
            </div>
            <div className={styles.tableListOperator}>
              <Button icon="plus" type="primary" onClick={() => this.handleCreate()}>新建</Button>
              {
                selectedRows.length > 0 && (
                  <span>
                    <Button onClick={this.handleModalVisible} type="danger" icon="delete">批量删除</Button>
                    <Button onClick={this.handleUpdate} type="primary" icon="update">批量更新</Button>
                    <Dropdown overlay={menu}>
                      <Button>
                        更多操作 <Icon type="down" />
                      </Button>
                    </Dropdown>
                  </span>
                )
              }
            </div>
            <CommunityTable
              selectedRows={selectedRows}
              loading={loading}
              data={data}
              count={count}
              current={currentPage}
              onSelectRow={this.handleSelectRows}
              onChange={this.handleStandardTableChange}
              owner={owner}
            />
          </div>
        </Card>
        {modalContent(data, owner)}
      </PageHeaderLayout>
    );
  }
}


