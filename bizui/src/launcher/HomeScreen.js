import FontAwesome from 'react-fontawesome';
import { Row, Col, Card, Table, Popconfirm, Button } from 'antd';

import React from 'react';

import TopMenu from './TopMenu';
import classNames from 'classnames'
//import BizRouter from './BizRouter'
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import styles  from './HomeScreen.less'



import { Layout } from 'antd';


const { Content, Footer } = Layout;

class HomeScreen extends React.Component {



    gotoApp = (e, app) => {
        console.log('click ', app.id);
        const dispatch = this.props.dispatch;
        dispatch({type:"launcher/gotoApp", payload:{app}});
    }



    appList = () => {
        return (<div>

            <FontAwesome name="user" />

        </div>)

    }

    lowercaseFirst = (stringExpr) => {
        if(typeof(stringExpr)!="string"){
            throw "parameter stringExpr is not a string";
        }
        //let stringExpr="";
        if(stringExpr.length<=0){
            return "";
        }
        if(stringExpr.length==1){
            return stringExpr.substring(0,1);
        }
        return stringExpr.substring(0,1).toLowerCase()+stringExpr.substring(1);
    }

    calcLink =(link)=>{
        let theCamelForm = this.lowercaseFirst(link);
        console.log("processing: "+theCamelForm);
        return theCamelForm+'App/dash';
        //return '/login';

    }

    render() {

        const appList = this.props.launcher.data.userAppList;
        const calcLink = this.calcLink;
        const { systemName }=this.props.launcher;
        const styleList="icon-effect-1 icon-effect-1a icon-item";
        var effectClasses = classNames({
            styleList
          });
      
        // console.log(styleList);

        return (<div className={"wrapper"}>
                <Row key="1" >
                    <Col className="gutter-row" span={24} >
                        <span className="logo"></span>
                        <TopMenu {...this.props} />
                    </Col>
                </Row>
                <Row key="2">
                    <Col className="gutter-row heading" span={24}>
                        <h1>{systemName}</h1>
                        <div className="desc"></div>
                        <a href="#more" className="btn">更多特性</a>
                    </Col>
                </Row>
                <Row key="3" className="icon-item-list" justify="center" align="center" id="more">
                    {appList.map((app, i) => (
                        <Col className={styleList} key={i}  span={6} style={{ textAlign: "center"}}
                            onClick={(e)=>this.gotoApp(e,app)}
                        >
                            <div className="icon-item-box">
                                <FontAwesome name={app.appIcon}  style={{color:'brown'}} className={"icon"}/>
                                <p>{app.title}</p> 
                            </div>
                        </Col>))}
                </Row>
            </div>)
    }
}


const mapStateToProps = state => {
    return state;
};
const mapDispatchToProps = dispatch => ({
    receiveData: bindActionCreators({}, dispatch)
});

//export default connect(mapStateToProps, mapDispatchToProps)(UserSkillBizApp);
export default connect(mapStateToProps)(HomeScreen);

