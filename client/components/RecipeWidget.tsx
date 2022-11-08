import Link from "next/link";

type componentProps = {
  name: string;
  imageUrl: string;
  id: number;
};

export default function RecipeWidget({ id, name, imageUrl }: componentProps) {
  return (
    <Link href={`/recipes/${id}`}>
      <div className="h-32 w-48 rounded-md bg-emerald-200 hover:shadow-md transform duration-150 hover:scale-110 hover:z-10 cursor-pointer flex flex-col group">
        <h1 className="border-emerald-600 border-b-2 text-center text-gray-800 group-hover:underline">
          {name}
        </h1>
        <img
          className="m-1 rounded-md object-cover w-[11.5rem] h-[5.849rem]"
          src={imageUrl}
          alt=""
        />
      </div>
    </Link>
  );
}
