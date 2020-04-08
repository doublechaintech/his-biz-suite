import { Tree, Input } from 'antd';

const { Search } = Input;


const sampleListData=[
  {
      "valuesOfGroupBy": [
          "中级职称",
          "副教授",
          
          
      ],
      "name": "曹顺庆",
      "id": "P000003",
  },
  {
      "valuesOfGroupBy": [
          "中级职称",
          "讲师",
      ],
      "name": "罗志田",
      "id": "P000004",
  },
  {
      "valuesOfGroupBy": [
          "初级职称",
          "助教",
      ],
      "name": "卿希泰",
      "id": "P000001",
  },
  {
      "valuesOfGroupBy": [
          "初级职称",
          "实习生",
      ],
      "name": "项楚",
      "id": "P000002",
  },
  {
    "valuesOfGroupBy": [
        "初级职称",
        "实习生",
    ],
    "name": "项楚2",
    "id": "P000005",
},
]


const subList=(listData,searchValue)=>{
    console.log("subList", listData)
    return listData.filter(item=>item.name&&item.name.indexOf(searchValue)>=0)
}
const allKeys=(listData)=>{
    return listData.map(item=>item.id)
}

  


const genTree=(listData, searchValue)=>{
    
    const parentNodes = [];
    const rootTree = {children:[]}
    subList(listData,searchValue)
      .map(item=>{

        const {valuesOfGroupBy} = item
        const child = {title:item.name,key:item.id}
        const {length} = valuesOfGroupBy
        if(valuesOfGroupBy && length === 0){
          // no parent node, the child it self is the root 
          rootTree.children.push(child)
          return
        }
        const itemParentNodes = []
        itemParentNodes.push(rootTree)
        // enrich all ancestors
        valuesOfGroupBy.forEach((groupItem,index)=>
          {
            const key = `${groupItem}-${index}`
            const itemParentNode = parentNodes[key]
            if(!itemParentNode){
              // if there are no node registered, then add it
              const newRootItem={title:groupItem,key,level:index,children:[]}
              parentNodes[key] = newRootItem
              itemParentNodes.push(newRootItem)
              return
            }
            // found! then push to parent nodes
            itemParentNodes.push(itemParentNode)

          }
        )
        itemParentNodes.push(child)

       
        // connect to all the ancestors
        itemParentNodes.forEach((node,index)=>{

          if(index>0){
            const prev = itemParentNodes[index-1]
            const current = itemParentNodes[index]
            if(prev.children.filter(childItem=>childItem.key===current.key).length===0){
              prev.children.push(current)
            }
          }
        })
        return {...item, itemParentNodes}
        // ensure parent nodes
        
           
    })
    
    return rootTree.children
    
    
}

/*

 <TreeSearch className={styles.tableList} 
                            callbackFunction={callbackFunction}
                            callbackParameters={callbackParameters}
                        />

*/

export default class TreeSearch extends React.Component {
  state = {
    expandedKeys: [],
    searchValue: '',
    candidateValues:[],
    autoExpandParent: true,
  };

  componentDidMount() {
   
    const {callbackFunction,callbackParameters} = this.props
    if(!callbackFunction||!callbackParameters){
        return
    }
    const future = callbackFunction(callbackParameters)

    future.then(data=>{
        console.log("data==========>",data)
        const candidateValues=data
        this.setState({candidateValues,expandedKeys:allKeys(data)})
        
    })


    //this.executeSearch("")
  }



  onExpand = expandedKeys => {
    this.setState({
      expandedKeys,
      autoExpandParent: false,
    });
  };

  onChange = e => {
    const { value } = e.target;
    const {candidateValues} = this.state
    const expandedKeys = subList(candidateValues, value)
      .map(item => {
        
        return item.id;
      })
    this.setState({
      expandedKeys,
      searchValue: value,
      autoExpandParent: true,
    });
  };

  render() {
    const { searchValue, expandedKeys, autoExpandParent , candidateValues} = this.state;
    const  treeData = genTree(candidateValues,searchValue)
    return (
      <div style={{marginRight:"10px", minHeight:'700px'}}>
        <Search style={{ marginBottom: 8 }} placeholder="搜索分类" onChange={this.onChange} />
       
        {(treeData.length>0)&&(<Tree
          defaultExpandAll
          onExpand={this.onExpand}
          expandedKeys={expandedKeys}
          autoExpandParent={autoExpandParent}
          treeData={treeData}
        />)}
        {treeData.lenth === 0&&(<div>请重新输入搜索条件</div>)}
      </div>
    );
  }
}

