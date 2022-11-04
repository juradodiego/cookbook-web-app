import { useRouter } from "next/router";
import { useEffect, useState } from "react";

// sample recipe placeholder until API connected
const sampleRecipe: Recipe = {
  id: 1,
  name: "Spaghetti and Meatballs",
  qualityRating: 3,
  description: "Classic Italian Spaghetti & Meatballs. Restauraunt style!",
  ingredients: ["Spaghetti", "Meatballs", "Red sauce", "Parmesan cheese"],
  estPrepTime: 10,
  estCookTime: 20,
  imageUrl: "https://images.spot.im/v1/production/nj5fh78jludisdu0nyne",
};

interface Recipe {
  id: number;
  name: string;
  description: string;
  instructions: string[];
  appliances: string[];
  ingredients: string[];
  qualityRating: number;
  difficultyRating: number;
  estCookTime: number;
  estPrepTime: number;
  cusisine: string;
  flavor: string;
  imageUrl: string;
}

export default function RecipePage() {
  const router = useRouter(); // router hook
  const { id } = router.query; // get recipe id from router query param

  const [recipe, setRecipe] = useState<Recipe | undefined>(undefined);

  // get recipe from API
  useEffect(() => {
    setRecipe(sampleRecipe);
  }, []);

  return (
    <div className="ml-8 flex flex-col space-y-5">
      <h1 className="text-4xl font-bold">{recipe?.name}</h1>
      <p className="text-gray-700 text-lg">{recipe?.description}</p>
      {recipe?.imageUrl && (
        <img
          className="object-scale-down object-left h-80 w-[75%]"
          src={recipe.imageUrl}
          alt={`Image of ${recipe.name}`}
        />
      )}
      <div className="w-96 h-40 bg-emerald-100 rounded-md grid grid-cols-2 px-5 py-2">
        <span>
          <p className="font-bold">Prep Time:</p>
          {recipe?.estPrepTime} mins
        </span>
        <span>
          <p className="font-bold">Cook Time:</p>
          {recipe?.estCookTime} mins
        </span>
        <span>
          <p className="font-bold">Total Time:</p>
          {recipe && recipe.estCookTime + recipe.estPrepTime} mins
        </span>
      </div>
      <h2 className="text-2xl font-bold">Ingredients:</h2>
      <ol className="list-decimal ml-4">
        {recipe?.ingredients.map((ingredient) => (
          <li>{ingredient}</li>
        ))}
      </ol>
    </div>
  );
}
