import { useLocation, useNavigate, useParams } from "react-router-dom";
import Button from "../components/Button";
import Header from "../components/Header";
import Editor from "../components/Editor";

const Edit = () => {
  const params = useParams();
  const nav = useNavigate();
  const { state } = useLocation();
  return (
    <div>
      <Header
        leftChild={<Button text={"< 뒤로가기"} onClick={() => nav(-1)} />}
        rightChild={<Button text={"삭제"} type={"NEGATIVE"} />}
        title={"일기 수정하기"}
      />
      <Editor data={state} />
    </div>
  );
};
export default Edit;
