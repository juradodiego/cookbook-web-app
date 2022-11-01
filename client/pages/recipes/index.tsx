import { useEffect, useState } from "react";
import RecipeWidget from "../../components/RecipeWidget";

const sampleRecipes: RecipeWidgetT[] = [
  {
    name: "Spaghetti and Meatballs",
    imageUrl:
      "https://hips.hearstapps.com/del.h-cdn.co/assets/17/39/2048x1024/landscape-1506456062-delish-spaghetti-meatballs.jpg?resize=1200:*",
    id: 1,
  },
];

interface RecipeWidgetT {
  name: string;
  imageUrl: string;
  id: number;
}

export default function Home() {
  const [recipes, setRecipes] = useState<RecipeWidgetT[] | undefined>(
    undefined
  );

  // initial fetch recipes using search + filter
  useEffect(() => {
    setRecipes(sampleRecipes);
  }, []);

  return (
    <div>
      {/* Individual recipe widgets */}
      <div className="flex mx-5 mt-2">
        {recipes?.map((recipe) => (
          <RecipeWidget
            name={recipe.name}
            imageUrl={recipe.imageUrl}
            id={recipe.id}
          />
        ))}
      </div>
    </div>
  );
}
