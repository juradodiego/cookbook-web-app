import Link from "next/link";

type NavProps = {
  text: string;
  url: string;
};

export const NavItem = ({ text, url }: NavProps) => {
  return (
    <Link href={url}>
      <div className="cursor-pointer hover:bg-green-300 active:bg-green-400 p-2 rounded-md">
        <p>{text}</p>
      </div>
    </Link>
  );
};
