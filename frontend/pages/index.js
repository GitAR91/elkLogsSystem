import Link from "next/link";


export default () => (
    <div>
        <ul>
            <li><Link href="/">Main page</Link></li>
            <li><Link href="/contacts">Contacts</Link></li>
        </ul>
        <p>My first page with NextJS</p>
    </div>
)