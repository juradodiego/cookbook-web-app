import { useEffect, useState } from "react";
import RecipeWidget from "../../components/RecipeWidget";
import NavBar from "../../components/NavBar";
import RecipeFilter from "../../components/RecipeFilter";
import Head from "next/head";

const sampleRecipes: RecipeWidgetT[] = [
  {
    name: "Spaghetti and Meatballs",
    imageUrl:
      "https://hips.hearstapps.com/del.h-cdn.co/assets/17/39/2048x1024/landscape-1506456062-delish-spaghetti-meatballs.jpg?resize=1200:*",
    id: 1,
  },
  {
    name: "Ramen Noodles",
    imageUrl:
      "https://glebekitchen.com/wp-content/uploads/2017/04/tonkotsuramenfront.jpg",
    id: 2,
  },
  {
    name: "Spaghetti and Meatballs",
    imageUrl:
      "https://hips.hearstapps.com/del.h-cdn.co/assets/17/39/2048x1024/landscape-1506456062-delish-spaghetti-meatballs.jpg?resize=1200:*",
    id: 1,
  },
  {
    name: "Spaghetti and Meatballs",
    imageUrl:
      "https://hips.hearstapps.com/del.h-cdn.co/assets/17/39/2048x1024/landscape-1506456062-delish-spaghetti-meatballs.jpg?resize=1200:*",
    id: 1,
  },
  {
    name: "Spaghetti and Meatballs",
    imageUrl:
      "https://hips.hearstapps.com/del.h-cdn.co/assets/17/39/2048x1024/landscape-1506456062-delish-spaghetti-meatballs.jpg?resize=1200:*",
    id: 1,
  },
  {
    name: "Spaghetti and Meatballs",
    imageUrl:
      "https://hips.hearstapps.com/del.h-cdn.co/assets/17/39/2048x1024/landscape-1506456062-delish-spaghetti-meatballs.jpg?resize=1200:*",
    id: 1,
  },
  {
    name: "Spaghetti and Meatballs",
    imageUrl:
      "https://hips.hearstapps.com/del.h-cdn.co/assets/17/39/2048x1024/landscape-1506456062-delish-spaghetti-meatballs.jpg?resize=1200:*",
    id: 1,
  },
  {
    name: "Spaghetti and Meatballs",
    imageUrl:
      "https://hips.hearstapps.com/del.h-cdn.co/assets/17/39/2048x1024/landscape-1506456062-delish-spaghetti-meatballs.jpg?resize=1200:*",
    id: 1,
  },
  {
    name: "Spaghetti and Meatballs",
    imageUrl:
      "https://hips.hearstapps.com/del.h-cdn.co/assets/17/39/2048x1024/landscape-1506456062-delish-spaghetti-meatballs.jpg?resize=1200:*",
    id: 1,
  },
  {
    name: "Spaghetti and Meatballs",
    imageUrl:
      "https://hips.hearstapps.com/del.h-cdn.co/assets/17/39/2048x1024/landscape-1506456062-delish-spaghetti-meatballs.jpg?resize=1200:*",
    id: 1,
  },
  {
    name: "Spaghetti and Meatballs",
    imageUrl:
      "https://hips.hearstapps.com/del.h-cdn.co/assets/17/39/2048x1024/landscape-1506456062-delish-spaghetti-meatballs.jpg?resize=1200:*",
    id: 1,
  },
  {
    name: "Spaghetti and Meatballs",
    imageUrl:
      "https://hips.hearstapps.com/del.h-cdn.co/assets/17/39/2048x1024/landscape-1506456062-delish-spaghetti-meatballs.jpg?resize=1200:*",
    id: 1,
  },
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
  // recipes from API request (unfiltered)
  const [recipes, setRecipes] = useState<RecipeWidgetT[] | undefined>(
    undefined
  );

  // initial fetch recipes using search + filter
  useEffect(() => {
    setRecipes(sampleRecipes);
  }, []);

  return (
    <div>
      <Head>
        <title>FoodDude - Recipes</title>
      </Head>
      <NavBar />
      {/* Search Bar */}
      <div className="flex mt-5 ml-5">
        <RecipeFilter />
        {/* Individual recipe widgets */}
        <div className="flex mx-5 mt-2 flex-wrap">
          {recipes?.map((recipe, index) => (
            <RecipeWidget
              name={recipe.name}
              imageUrl={recipe.imageUrl}
              id={recipe.id}
              key={index}
            />
          ))}
        </div>
      </div>
    </div>
  );
}
