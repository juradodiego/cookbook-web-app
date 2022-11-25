import Link from "next/link";

type componentProps = {
  name: string;
  imageUrl: string;
  id: number;
};

export default function RecipeWidget({ id, name, imageUrl }: componentProps) {
  return (
    <Link href={`/recipes/${id}`}>
      <div className="select-none bg-white rounded-md w-56 flex flex-col transition duration-100 hover:scale-105">
        <img src={imageUrl} className="w-56 h-40 object-cover rounded-t-md" />
        <div className="w-56 h-28">
          <p className="text-2xl text-gray-800 p-3 font-serif">{name}</p>
        </div>
      </div>
    </Link>
  );
}
