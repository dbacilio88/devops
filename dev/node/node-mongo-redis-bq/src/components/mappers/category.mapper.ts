
import { Mapper } from "@automapper/core";
import { InjectMapper } from "@automapper/nestjs";
import { Injectable } from "@nestjs/common";
import { MapperBase } from "../base/mapper.base";
import { CategoryDocument } from "src/api/documents/Category.document";
import { CategoryDto } from "src/dtos/Category.dto";

@Injectable()
export class CategoryMapper extends MapperBase<CategoryDocument, CategoryDto> {

    constructor(@InjectMapper() private mapper: Mapper) {
        super(mapper);
    }


    override  mapToDtoAsync(entity: CategoryDocument): Promise<CategoryDto> {
        return this.mapper.mapAsync<CategoryDocument, CategoryDto>(entity, CategoryDocument, CategoryDto);
    }

    override mapToEntityAsync(dto: CategoryDto): Promise<CategoryDocument> {
        return this.mapper.mapAsync<CategoryDto, CategoryDocument>(dto, CategoryDto, CategoryDocument);
    }

    override mapToDtosAsync(entities: CategoryDocument[]): Promise<CategoryDto[]> {
        const dtos = this.mapper.mapArrayAsync<CategoryDocument, CategoryDto>(entities, CategoryDocument, CategoryDto);
        return dtos;
    }

    override mapToEntitiesAsync(dtos: CategoryDto[]): Promise<CategoryDocument[]> {
        return this.mapper.mapArrayAsync<CategoryDto, CategoryDocument>(dtos, CategoryDto, CategoryDocument);
    }

    override  mapToDto(entity: CategoryDocument): CategoryDto {
        return this.mapper.map<CategoryDocument, CategoryDto>(entity, CategoryDocument, CategoryDto);
    }

    override mapToEntity(dto: CategoryDto): CategoryDocument {
        return this.mapper.map<CategoryDto, CategoryDocument>(dto, CategoryDto, CategoryDocument);
    }

    override mapToDtos(entities: CategoryDocument[]): CategoryDto[] {
        const dtos = this.mapper.mapArray<CategoryDocument, CategoryDto>(entities, CategoryDocument, CategoryDto);
        return dtos;
    }

    override mapToEntities(dtos: CategoryDto[]): CategoryDocument[] {
        return this.mapper.mapArray<CategoryDto, CategoryDocument>(dtos, CategoryDto, CategoryDocument);
    }
}