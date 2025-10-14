import axios from "axios";

const Getsession = async () => {
  try {
    const res = await axios.get("/api/getSession");
    return res.data;
  } catch {
    return false;
  }
};

export default Getsession;
