import { emotionList } from "../util/constants";
import { getEmotionImage } from "../util/get-emotion-image";
import "./View.css";

const View = ({ data }) => {
  const emotionItem = emotionList.find(
    (item) => String(data.emotion) === String(item.emotion)
  );

  return (
    <div className="View">
      <section className="img_section">
        <h4>오늘의 감정</h4>
        <div className="emotion_img_wrapper">
          <img src={getEmotionImage(emotionItem.emotion)} />
          <div>{emotionItem.emotionName}</div>
        </div>
      </section>
      <section className="title_section">
        <h4>제목</h4>
        <div className="title_wrapper">
          <p>{data.title}</p>
        </div>
      </section>
      <section className="content_section">
        <h4>오늘의 일기</h4>
        <div className="content_wrapper">
          <p>{data.content}</p>
        </div>
      </section>
    </div>
  );
};
export default View;
