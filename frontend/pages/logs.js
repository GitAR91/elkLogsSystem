import axios from "axios";

export default function Logs({logs, error}){
    if (error) {
        return <div>An error occured: {error.message}</div>;
    }
    return (
        <p>{logs}</p>
    );
};

Logs.getInitialProps = async getLogs => {
    try{
        const log = await axios.get('http://localhost:8080/logs/test');
        const logs = log.data;
        return { logs }
    } catch (error) {
        return { error };
    }
}