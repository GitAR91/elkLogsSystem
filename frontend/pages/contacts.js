import Link from "next/link";

const  Contacts= () =>  (
    <div>
        <ul>
            <li><Link href="/">Main page</Link></li>
            <li><Link href="/contacts">Contacts</Link></li>
        </ul>
        <p><a href="mailto:vorontsova_mi@soshace.com">Contact me!</a></p>
    </div>
);
export default Contacts;