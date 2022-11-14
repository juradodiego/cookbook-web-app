import { ChevronLeftIcon, ChevronRightIcon } from "@heroicons/react/24/outline";
import { Children, useState } from "react";

export default function Carousel({ children }: any) {
  const [activeIndex, setActiveIndex] = useState(0);

  const updateIndex = (index: number) => {
    let newIndex = index;

    if (newIndex < 0) newIndex = 0;
    else if (newIndex >= Children.count(children))
      newIndex = Children.count(children) - 1;

    setActiveIndex(newIndex);
  };

  return (
    <div className="flex items-center space-x-1">
      <ChevronLeftIcon
        className="h-8 cursor-pointer text-gray-600 hover:text-gray-800 active:text-black"
        onClick={() => updateIndex(activeIndex - 1)}
      />
      <div className="overflow-hidden">
        <div
          className={`whitespace-nowrap w-[30rem] transform duration-300 translate-x-[-${
            activeIndex * 100
          }%]`}
        >
          {children}
        </div>
      </div>
      <ChevronRightIcon
        className="h-8 cursor-pointer text-gray-600 hover:text-gray-800 active:text-black"
        onClick={() => updateIndex(activeIndex + 1)}
      />
    </div>
  );
}
