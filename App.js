import {Children, useCallback, useEffect, useRef, useState} from 'react';
import axios from 'axios';

function App() {
  const[members, setMembers] = useState([]);
  const[items, setItems] = useState([]);

  const memberNameRef = useRef(null);
  const[memberName,setMemberName] = useState("");

  const getMember = async()=>{
    await axios
    .get('http://localhost:8080/members', {})
    .then((res)=>{
      setMembers(res.data);
    })
    .catch((err)=>{
      console.log(err);
    });
  };

  const itemNameRef = useRef(null);
  const [itemName, setItemName] = useState("");
  const itemCountRef = useRef(null);
  const [itemCount, setItemCount] = useState("");

  const getItems = async()=>{
    await axios
    .get('http://localhost:8080/items', {})
    .then((res) => {
      setItems(res.data);
    })
    .catch((err) => {
      console.log(err);
    });
  };
  useEffect(() => {
    getMember();
    getItems();
  },[]);

  const onClickMakePerson = useCallback(async () => {
    const params = {
      name: memberName,
    };

    await axios
      .post(`http://localhost:8080/members`, params)
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  }, [memberName]);

  const onClickMakeArticle = useCallback(async () => {
    const params = {
      name: itemName,
      count: Number(itemCount),
    };

    await axios
      .post(`http://localhost:8080/items`, params)
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });

    console.log(params);
  }, [itemName, itemCount]);

  return (
    <div
      style={{
        height: '100vh',
        display: 'flex',
        flexDirection: 'column',
        gap: '20px',
        justifyContent: 'center',
        alignItems: 'center',
      }}
    >
      <div style={{ display: 'flex', gap: '20px' }}>
        <table border="1" align={'center'}>
          <tbody>
            <tr>
              <th>아이디</th>
              <th>이름</th>
            </tr>
            {Children.toArray(
              members.map((v) => (
                <tr>
                  <td>{v.id}</td>
                  <td>{v.name}</td>
                </tr>
              )),
            )}
          </tbody>
        </table>
        <div style={{ display: 'flex', gap: '20px' }}>
          <input
            type={'text'}
            ref={memberNameRef}
            onChange={(event) => {
              setMemberName(event.target.value);
            }}
          />
          <button onClick={() => onClickMakePerson()}>사람 만들기</button>
        </div>
      </div>

      <div style={{ display: 'flex', gap: '20px' }}>
        <table border="1" align={'center'}>
          <tbody>
            <tr>
              <th>아이디</th>
              <th>이름</th>
              <th>수량</th>
            </tr>
            {items.map((v) => (
              <tr>
                <td>{v.id}</td>
                <td>{v.name}</td>
                <td>{v.count}</td>
              </tr>
            ))}
          </tbody>
        </table>
        <div style={{ display: 'flex', gap: '20px' }}>
          <input
            type={'text'}
            ref={itemNameRef}
            onChange={(event) => {
              setItemName(event.target.value);
            }}
          />
          <input
            type={'number'}
            ref={itemCountRef}
            onChange={(event) => {
              setItemCount(event.target.value);
            }}
          />
          <button onClick={() => onClickMakeArticle()}>물품 만들기</button>
        </div>
      </div>
    </div>
  );
}


    <div>

    </div>

export default App;
